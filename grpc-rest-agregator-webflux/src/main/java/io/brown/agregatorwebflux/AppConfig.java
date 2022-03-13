package io.brown.agregatorwebflux;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@Slf4j
public class AppConfig {

    @Value("${rest.greeting-service.endpoint}")
    private String webClientEndpoint;

    @Bean
    public WebClient greetingWebClient() {
        return WebClient.builder()
                .baseUrl(webClientEndpoint)
                .build();
    }
}
