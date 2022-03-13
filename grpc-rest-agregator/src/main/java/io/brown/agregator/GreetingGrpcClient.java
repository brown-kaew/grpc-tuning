package io.brown.agregator;

import io.brown.GreetingServiceGrpc;
import io.brown.HelloReply;
import io.brown.HelloRequest;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class GreetingGrpcClient {

    @GrpcClient("greeting-service")
    GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub;

    public String hello(String name) {
        HelloReply helloReply = blockingStub.sayHello(HelloRequest.newBuilder()
                .setName(name)
                .build());
        return helloReply.getMessage();
    }
}
