package com.example.serverfegin.service.impl;

import com.example.serverfegin.service.HelloFeignService;

/**
 * @author Admin
 */
public class HelloFeignServiceImpl implements HelloFeignService {



    @Override
    public String sayHiFromClientOne(String name) {
        return "hello"+name;
    }
}
