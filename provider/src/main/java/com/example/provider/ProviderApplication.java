package com.example.provider;

import brave.Tracing;
import brave.context.log4j2.ThreadContextScopeDecorator;
import brave.propagation.ThreadLocalCurrentTraceContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.provider.proxy")
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
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
