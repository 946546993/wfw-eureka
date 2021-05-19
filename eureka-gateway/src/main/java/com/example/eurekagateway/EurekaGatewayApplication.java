package com.example.eurekagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaGatewayApplication.class, args);
    }

}
