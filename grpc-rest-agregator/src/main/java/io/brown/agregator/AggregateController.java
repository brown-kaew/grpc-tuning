package io.brown.agregator;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class AggregateController {

    private final GreetingGrpcClient greetingGrpcClient;

    @GetMapping("grpc/greeting")
    public String greeting() {
        return greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10));
    }

}
