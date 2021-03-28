package com.demo.hello.grpcserver.service.impl;

import com.demo.grpc.api.HelloGrpc;
import com.demo.grpc.api.HelloRequest;
import com.demo.grpc.api.HelloResponse;
import com.demo.hello.grpcserver.service.HelloService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class HelloServiceImpl extends HelloGrpc.HelloImplBase implements HelloService {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getMessage();
        System.out.println("received:" + name);
        HelloResponse response = HelloResponse.newBuilder().setResponse("hello" + request.getMessage()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
