package com.example.eurekaclient.annotation;

import java.lang.annotation.*;

/**
 * @author hzx
 * 自定义注解测试
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TestTrack {

    String value() default "logTracking";
}
