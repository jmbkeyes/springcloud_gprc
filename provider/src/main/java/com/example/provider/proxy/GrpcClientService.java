package com.example.provider.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "grpc-client")
public interface GrpcClientService {
    @RequestMapping(value = "/test/hello")
    String hello(@RequestParam(value = "name")String name);

    @RequestMapping(value = "/test/hello2")
    String hello2(@RequestBody  String name);
}
