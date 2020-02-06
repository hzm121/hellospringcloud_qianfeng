package com.hzm.hellospringcloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hzm
 * @date : 2020-02-06 14:12
 */
@RestController
public class AdminController {
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(String msg){
        return String.format("your msg is %s,your port is %s",msg,port);
    }
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String sayHi2(){
        return String.format("your msg is,your port is %s",port);
    }
}
