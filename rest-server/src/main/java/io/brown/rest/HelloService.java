package io.brown.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Service
public class HelloService {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public String hello(String name) {
        String message = String.format("Hello %s [%s]", name, ID_GENERATOR.incrementAndGet());
        log.info(message);
        return message;
    }
}
