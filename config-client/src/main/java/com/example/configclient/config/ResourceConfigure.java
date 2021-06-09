package com.example.configclient.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ResourceConfigure {

//    @Bean
//    public static PropertySourcesPlaceholderConfigurer properties() {
//        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
//        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
//        yaml.setResources(new ClassPathResource("baidu-map-config.yml"));
//        configurer.setProperties(yaml.getObject());
//        return configurer;
//    }
}