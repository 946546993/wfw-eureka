package com.example.serverfegin.service.impl;

import com.example.serverfegin.service.HelloFeignService;
import org.springframework.stereotype.Component;

/**
 * @author Admin
 */
@Component
public class HelloFeignServiceImpl implements HelloFeignService {

    @Override
    public String sayHiFromClientOne(String name) {
        System.out.println("熔断方法");
        return "sorry，"+name+". Service is busy....";
    }
}
