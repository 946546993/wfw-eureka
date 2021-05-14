package com.example.serviceribbonhystrix.controller;

import com.example.serviceribbonhystrix.service.HelloRibbonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzx
 */
@Slf4j
@RestController("test")
public class HelloRibbonController {

    @Resource
    private HelloRibbonService helloRibbonService;


    /**
     * 场景总结：
     *
     * 　　1.一个服务注册中心，eureka-server端口为8761
     *
     * 　　2.向服务注册中心eureka-server注册两个客户端服务：名称为eureka-client-01包含服务：8762/8763
     *
     * 　　3.向服务之策中心eureka-server注册消费者服务：service-ribbon端口：8764
     *
     * 　　4.当service-ribbon通过restTemplate调用eureka-client-01的hi接口时，因为用了ribbon负载均衡，会轮流的调用eureka-client-01：8762和8763两个端口的hi接口；
     * @return
     */
    @GetMapping("hi")
    public String hi() {
        String result = helloRibbonService.hiService("hzx");
        log.error(result);
        return result;
    }


}
