package com.example.serviceribbon.service.impl;

import com.example.serviceribbon.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author hzx
 */
@Service
public class HelloRibbonServiceImpl implements HelloRibbonService {


    @Autowired
    private RestTemplate restTemplate;



    @Override
    public String hiService(String name) {
        //使用注册到Eureka服务中心的客户端，由客户端分配具体调用哪个服务
        return restTemplate.getForObject("http://eureka-client-01/demo/hi?name="+name,String.class);

    }
}
