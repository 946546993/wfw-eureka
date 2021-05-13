package com.example.serviceribbon.controller;

import com.example.serviceribbon.service.HelloRibbonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("hi")
    public String hi() {
        String result = helloRibbonService.hiService("hzx");
        log.error(result);
        return result;
    }


}
