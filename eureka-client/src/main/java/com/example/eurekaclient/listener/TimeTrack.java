package com.example.eurekaclient.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 定时任务
 */
@Slf4j
@Configuration
@EnableScheduling
public class TimeTrack {

    /**
     * 每5秒执行一次
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void identityCheck(){
        log.info("定时器 --  identityCheck 开始定时任务");

    }
}
