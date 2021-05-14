package com.example.serviceribbonhystrix.service.impl;


import com.example.serviceribbonhystrix.service.HelloRibbonService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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


    /**
     * 断路机制，如果失败，就返回 hiError  的结果
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod="hiError")
    @Override
    public String hiService(String name) {
        //使用注册到Eureka服务中心的客户端，由客户端分配具体调用哪个服务
        return restTemplate.getForObject("http://eureka-client-01/demo/hi?name="+name,String.class);
    }

    public String hiError(String name){
        return "hi" + name +"sorry,error!";
    }

}
