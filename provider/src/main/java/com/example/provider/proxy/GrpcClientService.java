package com.example.provider.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "grpc-client")
public interface GrpcClientService {
    @RequestMapping(value = "/test/hello")
    String hello();
}
