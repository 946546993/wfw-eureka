package com.example.eurekaclient.content;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author hzx
 */
@Data
@Component
public class MyConfig02 {
    @Value("${test02.user.name}")
    private String userName;
    @Value("${test02.work.name}")
    private String workName;

}
