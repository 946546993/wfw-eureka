package com.example.configclient.controller;

import com.example.configclient.config.GitAutoRefreshConfig;
import com.example.configclient.config.GitConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzx
 */
@RestController
@RefreshScope
public class GitController {


    @Autowired
    private GitConfig gitConfig;

    @Autowired
    private GitAutoRefreshConfig gitAutoRefreshConfig;

    /**
     *    “@Value”注解不能实现配置刷新功能
     * @return
     */
    @GetMapping(value = "show")
    public Object show(){
        return gitConfig;
    }

    /**
     * 刷新配置  发送post请求到： http://localhost:8788/actuator/refresh
     * 后续用到 webhook  当有提交的时候，发送一个接口请求，实现单一client端的配置刷新
     * 多client 端的配置刷新， 结合webhook + MQ   使用消息广播的形式，可实现多端的配置自动更新
     * @return
     */
    @GetMapping(value = "autoShow")
    public Object autoShow(){
        return gitAutoRefreshConfig;
    }

}
