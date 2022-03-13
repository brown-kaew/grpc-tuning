package io.brown.agregatorwebflux;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/flux")
@RequiredArgsConstructor
public class AggregateController {

    private final GreetingGrpcClient greetingGrpcClient;
    private final GreetingRestClient greetingRestClient;

    @GetMapping("grpc/greeting")
    public Mono<String> grpcGreeting() {
        return Mono.just(greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10)));
    }

    @GetMapping("grpc/greeting/{times}")
    public Flux<String> grpcGreeting(@PathVariable int times) {
        return Flux.range(1, times)
                .flatMap(integer -> Flux.just(greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10))));
    }


    @GetMapping("rest/greeting")
    public Mono<String> restGreeting() {
        return greetingRestClient.hello(RandomStringUtils.randomAlphabetic(10));
    }

    @GetMapping("rest/greeting/{times}")
    public Flux<Object> restGreeting(@PathVariable int times) {
        return Flux.range(1, times)
                .flatMap(integer -> greetingRestClient.hello(RandomStringUtils.randomAlphabetic(10)));
    }

}
