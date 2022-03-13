package io.brown.grpc;

import io.brown.GreetingServiceGrpc;
import io.brown.HelloReply;
import io.brown.HelloRequest;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@Slf4j
@RequiredArgsConstructor
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    private final HelloService helloService;

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = helloService.hello(request.getName());
        responseObserver.onNext(HelloReply.newBuilder()
                .setMessage(message)
                .build());
        responseObserver.onCompleted();
        log.info(message);
    }
}
