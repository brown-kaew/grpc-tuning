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
    private final GreetingRestClient greetingRestClient;

    @GetMapping("grpc/greeting")
    public String grpcGreeting() {
        return greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10));
    }

    @GetMapping("grpc/greeting/{times}")
    public String grpcGreeting(@PathVariable int times) {
        StringBuilder massages = new StringBuilder();
        int i = 0;
        while (i < times) {
            massages.append(greetingGrpcClient.hello(RandomStringUtils.randomAlphabetic(10)));
            i++;
        }
        return massages.toString();
    }


    @GetMapping("rest/greeting")
    public String restGreeting() {
        return greetingRestClient.hello(RandomStringUtils.randomAlphabetic(10));
    }

    @GetMapping("rest/greeting/{times}")
    public String restGreeting(@PathVariable int times) {
        StringBuilder massages = new StringBuilder();
        int i = 0;
        while (i < times) {
            massages.append(greetingRestClient.hello(RandomStringUtils.randomAlphabetic(10)));
            i++;
        }
        return massages.toString();
    }

}
