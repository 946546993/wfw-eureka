package com.example.eurekaclient.content;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 * @author hzx
 */
@Slf4j
@Configuration
@DependsOn({"beforeConfig"})
public class ResourceConfig {

    @Autowired
    private static BeforeConfig bean;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {

        //todo   失败   不能再加载this bean之前优先加载BeforeConfig
        if(bean == null){
            log.error("beforeConfig is null !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource("my-config.yml"),new ClassPathResource("my-config-02.yml"));
        configurer.setProperties(yaml.getObject());
        return configurer;
    }


}
