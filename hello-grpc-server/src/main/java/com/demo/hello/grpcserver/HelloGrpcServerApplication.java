package com.demo.hello.grpcserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloGrpcServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloGrpcServerApplication.class, args);
    }
}
