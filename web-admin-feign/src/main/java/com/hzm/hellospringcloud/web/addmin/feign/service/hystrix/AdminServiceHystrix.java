package com.hzm.hellospringcloud.web.addmin.feign.service.hystrix;

import com.hzm.hellospringcloud.web.addmin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @author : hzm
 * @date : 2020-02-06 20:00
 */
@Component
public class AdminServiceHystrix implements AdminService {
    @Override
    public String sayHi(String msg) {
        return String.format("your msg is %s but request is error",msg);
    }
}
