package com.example.provider.controller;

import com.example.provider.proxy.GrpcClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    @Autowired
    GrpcClientService grpcClientService;
    @RequestMapping(value = "")
    public Object index(){
        return "hello";
    }

    @RequestMapping(value = "callgrpc")
    public Object callGrpc(){
        return grpcClientService.hello();
    }
}
