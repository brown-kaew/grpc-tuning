package io.brown.agregator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class AppConfig {

    @Value("${rest.greeting-service.endpoint}")
    private String webClientEndpoint;

    @Bean
    public RestTemplate greetingRestTemplate(RestTemplateBuilder builder) {
        RestTemplate restTemplate = builder.build();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(webClientEndpoint));
        return restTemplate;
    }
}
