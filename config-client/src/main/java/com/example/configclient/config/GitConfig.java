package com.example.configclient.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hzx
 */
@Component
@Data
public class GitConfig {

    @Value("${data.env}")
    private String env;

    @Value("${data.user.username}")
    private String username;

    @Value("${data.user.password}")
    private String password;
}
