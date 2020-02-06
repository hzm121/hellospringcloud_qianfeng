package com.hzm.spring.cloud.web.admin.ribbon.service;

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

    public String sayHi(String msg){
        String forObject = restTemplate.getForObject("http://hellospringcloud-service-admin/getMsg?msg=123", String.class);
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://hellospringcloud-service-admin/getMsg?msg=123", String.class);

        return forObject;
    }
}

