package io.brown.agregator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class GreetingRestClient {

    @Value("${rest.greeting-service.api.greeting}")
    private String greetingPath;

    private final RestTemplate greetingRestTemplate;

    public String hello(String name) {
        UriComponents builder = UriComponentsBuilder.fromPath(greetingPath)
                .queryParam("name", name)
                .build();
        return greetingRestTemplate.getForObject(builder.toUriString(), String.class);
    }
}
