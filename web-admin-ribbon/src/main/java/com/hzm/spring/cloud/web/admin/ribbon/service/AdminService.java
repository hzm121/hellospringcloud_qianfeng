package com.hzm.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : hzm
 * @date : 2020-02-06 16:04
 */
@Service
public class AdminService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "sayHiError")
    public String sayHi(String msg){
        String forObject = restTemplate.getForObject("http://hellospringcloud-service-admin/getMsg?msg=123", String.class);
        return forObject;
    }

    public String sayHiError(String msg){
        return String.format("your msg is %s but request is error",msg);
    }

}

