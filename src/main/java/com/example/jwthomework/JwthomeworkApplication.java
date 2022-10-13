package com.example.jwthomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JwthomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwthomeworkApplication.class, args);
    }

}
