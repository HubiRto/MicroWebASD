package pl.pomoku.authservice.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.pomoku.authservice.entity.Role;
import pl.pomoku.authservice.repository.RoleRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleInitializer implements CommandLineRunner {
    private final RoleRepository repository;
    @Override
    public void run(String... args) {
        List<String> roles = List.of("USER", "ADMIN", "MODERATOR");
        roles.forEach(role -> {
            if(!repository.existsByName(role)){
                repository.save(new Role(role));
            }
        });
    }
}
