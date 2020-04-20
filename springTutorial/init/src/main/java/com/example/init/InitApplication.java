package com.example.init;

import com.example.init.pojo.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InitApplication {

    @Bean
    public CommandLineRunner cmd(RestTemplate restTemplate) {
        return args -> {
            Quote q = restTemplate
                    .getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            System.out.println("Got quote - " + q);
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(InitApplication.class, args);
    }

}
