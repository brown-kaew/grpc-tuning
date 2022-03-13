package io.brown.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class GreetingController {

    private final HelloService helloService;

    @GetMapping("greeting")
    public String greeting(@RequestParam String name) {
        return helloService.hello(name);
    }
}
