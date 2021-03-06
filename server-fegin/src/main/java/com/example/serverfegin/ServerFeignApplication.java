package com.example.serverfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hzx
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
public class ServerFeignApplication {

    /**
     * todo feign熔断有问题
     */


    /**
     * 1.Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。
     * 　　使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。
     * 　　Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果
     * 2.简单理解：
     * 　　·Feign 采用的是基于接口的注解
     * 　　·Feign 整合了ribbon
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ServerFeignApplication.class, args);
    }




}
