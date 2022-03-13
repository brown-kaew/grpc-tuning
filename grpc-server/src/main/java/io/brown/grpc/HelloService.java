package io.brown.grpc;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class HelloService {

    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    public String hello(String name) {
        return String.format("Hello %s [%s]", name, ID_GENERATOR.incrementAndGet());
    }
}
