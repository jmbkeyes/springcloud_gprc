package com.demo.grpcclient.service;

import com.demo.grpc.api.HelloGrpc;
import com.demo.grpc.api.HelloRequest;
import com.demo.grpc.api.HelloResponse;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloGrpcClient {
    @GrpcClient("hello-grpc-server")
    //HelloGrpc.HelloBlockingStub stub;
    Channel channel;

    public String hello(String name) {
        HelloGrpc.HelloBlockingStub stub = HelloGrpc.newBlockingStub(channel);
        HelloRequest.Builder builder= HelloRequest.newBuilder().
                setMessage(name);
        HelloResponse response = stub.hello(builder.build());
        return "{'responseStatus':'"+response.getResponse()+"','result':[]}";

    }
}
