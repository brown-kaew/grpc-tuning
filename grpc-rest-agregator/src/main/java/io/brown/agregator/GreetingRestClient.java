package io.brown.agregator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
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
        String message = greetingRestTemplate.getForObject(builder.toUriString(), String.class);
        log.info(message);
        return message;
    }
}
