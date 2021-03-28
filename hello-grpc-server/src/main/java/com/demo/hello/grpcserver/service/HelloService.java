package com.demo.hello.grpcserver.service;

import com.demo.grpc.api.HelloRequest;
import com.demo.grpc.api.HelloResponse;
import io.grpc.stub.StreamObserver;

public interface HelloService {
    void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver);
}
