package pl.pomoku.apigateway.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import pl.pomoku.apigateway.exception.AppException;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthFilter extends AbstractGatewayFilterFactory<Config> {
    private final RouteValidator routeValidator;
    private final WebClient webClient = WebClient.builder().baseUrl("http://AUTH-SERVICE").build();
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    return chain.filter(exchange);
                }
            }

            String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
            String token;
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
            }else {
                throw new AppException("Brak tokena", HttpStatus.FORBIDDEN);
            }

            return webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/validate")
                            .queryParam("token", token)
                            .build())
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .flatMap(isValid -> {
                        if (Boolean.TRUE.equals(isValid)) {
                            return chain.filter(exchange);
                        } else {
                            return Mono.error(new AppException(
                                    "Token wygasł",
                                    HttpStatus.FORBIDDEN
                            ));
                        }
                    })
                    .onErrorResume(e -> Mono.error(new AppException(
                            "Błąd w komunikacji z AuthService",
                            HttpStatus.INTERNAL_SERVER_ERROR
                    )));
        });
    }
}
