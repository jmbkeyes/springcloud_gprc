package com.demo.grpcclient;

import brave.Tracing;
import brave.context.log4j2.ThreadContextScopeDecorator;
import brave.propagation.ThreadLocalCurrentTraceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GrpcClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrpcClientApplication.class, args);
    }

    @Bean
    public Tracing tracing() {
        return Tracing.newBuilder()
                .currentTraceContext(ThreadLocalCurrentTraceContext.newBuilder()
                        .addScopeDecorator(ThreadContextScopeDecorator.get())
                        .build()
                ).build();
    }
}
