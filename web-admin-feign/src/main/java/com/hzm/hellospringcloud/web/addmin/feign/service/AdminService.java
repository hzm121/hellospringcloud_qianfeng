package com.hzm.hellospringcloud.web.addmin.feign.service;

import com.hzm.hellospringcloud.web.addmin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//value为服务提供者的名字
@FeignClient(value = "hellospringcloud-service-admin",fallback = AdminServiceHystrix.class)
public interface AdminService {
    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "msg") String msg);

}
