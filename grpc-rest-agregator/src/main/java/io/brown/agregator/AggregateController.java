package io.brown.agregator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class AggregateController {

    private final GreetingGrpcClient greetingGrpcClient;

    @GetMapping("grpc/greeting")
    public String greeting() {
        log.info("grpc/greeting");
        return greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10));
    }

    @GetMapping("grpc/greeting/{times}")
    public String greeting(@PathVariable int times) {
        log.info("grpc/greeting/{}", times);
        int i = 0;
        while (i < times) {
            greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10));
            i++;
        }
        return String.format("Done %s times", times);
    }

}
