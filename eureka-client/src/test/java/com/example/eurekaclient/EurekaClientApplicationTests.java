package com.example.eurekaclient;

import com.example.eurekaclient.content.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaClientApplicationTests {
    @Autowired
    MyConfig config;

    @Test
    void contextLoads() {

    }

    @Test
    void test(){
        System.out.println(config);
    }



}
