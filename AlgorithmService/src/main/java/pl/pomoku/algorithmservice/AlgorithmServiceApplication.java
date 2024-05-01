package pl.pomoku.algorithmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AlgorithmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmServiceApplication.class, args);
    }
}
