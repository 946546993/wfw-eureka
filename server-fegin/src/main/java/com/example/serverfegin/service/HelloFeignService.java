package com.example.serverfegin.service;

import com.example.serverfegin.service.impl.HelloFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 断路机制
 * fallback:失败就返回此结果
 * @author hzx
 */
@FeignClient(value = "eureka-client-01",fallback = HelloFeignServiceImpl.class)
public interface HelloFeignService {

    @GetMapping(value = "/demo/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
