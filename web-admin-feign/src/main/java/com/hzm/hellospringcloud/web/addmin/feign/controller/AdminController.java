package com.hzm.hellospringcloud.web.addmin.feign.controller;

import com.hzm.hellospringcloud.web.addmin.feign.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hzm
 * @date : 2020-02-06 16:45
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value = "hi",method = RequestMethod.GET)
    public String sayHi(String msg){
        return adminService.sayHi(msg);
    }
}
