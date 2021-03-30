package com.example.provider.controller;

import com.example.provider.proxy.GrpcClientService;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    private Logger logger= LoggerFactory.getLogger("providerLogger");
    @Autowired
    GrpcClientService grpcClientService;
    @RequestMapping(value = "")
    public Object index(){
        return "hello";
    }

    @RequestMapping(value = "callgrpc")
    public Object callGrpc(@RequestParam(value = "name")String name){
        logger.info("call rpc");
        return grpcClientService.hello(name);
    }

    @RequestMapping(value = "callgrpc2")
    public Object callGrpc2(@RequestParam(value = "name")String name){
        logger.info("call rpc2");
        return grpcClientService.hello2(name);
    }
}
