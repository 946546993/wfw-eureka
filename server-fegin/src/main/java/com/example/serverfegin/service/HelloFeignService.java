package com.example.serverfegin.service;

import com.example.serverfegin.service.impl.HelloFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 断路机制
 * fallback:失败就返回此结果
 * @author hzx
 */
@Component
@FeignClient(value = "eureka-client-01",fallback = HelloFeignServiceImpl.class)
public interface HelloFeignService {

    @RequestMapping(value = "/demo/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
