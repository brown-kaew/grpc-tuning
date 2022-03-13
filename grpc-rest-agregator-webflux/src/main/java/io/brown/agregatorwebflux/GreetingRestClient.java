package io.brown.agregatorwebflux;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class GreetingRestClient {

    @Value("${rest.greeting-service.api.greeting}")
    private String greetingPath;

    private final WebClient greetingWebClient;

    public Mono<String> hello(String name) {
        return greetingWebClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(greetingPath)
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }
}
