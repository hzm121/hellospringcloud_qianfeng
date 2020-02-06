package com.hzm.hellospringcloud.web.addmin.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : hzm
 * @date : 2020-02-06 16:39
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class WebAdminFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminFeignApplication.class,args);
    }
}
