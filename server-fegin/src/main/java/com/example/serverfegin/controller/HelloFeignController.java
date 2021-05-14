package com.example.serverfegin.controller;

import com.example.serverfegin.service.HelloFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzx
 */
@RestController
public class HelloFeignController {



    @Resource
    private HelloFeignService helloFeignService;
    @GetMapping(value = "hi")
    public String sayHi(){
        return helloFeignService.sayHiFromClientOne("hzx");
    }
}
