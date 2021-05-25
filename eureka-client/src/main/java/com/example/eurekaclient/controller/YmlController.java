package com.example.eurekaclient.controller;

import com.example.eurekaclient.annotation.TestTrack;
import com.example.eurekaclient.content.MyConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzx
 */
@Slf4j
@RestController
@RequestMapping("bind")
public class YmlController {

    @Resource
    private MyConfig config;


    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }


    @GetMapping("getYml")
    public String get(){
        String result = new String();
        result = config.toString();
        return result;
    }

    @TestTrack
    @GetMapping("trackTest")
    public String testTrack(@RequestParam String arg){
        System.out.println("=======已经进入接口中========");
        return arg;
    }

}
