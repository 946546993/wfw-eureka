package com.example.eurekaclient.content;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hzx
 */
@Component
@Data
public class BeforeConfig {


    @Value("${resourceYml.path}")
    private String resourceYml;



}
