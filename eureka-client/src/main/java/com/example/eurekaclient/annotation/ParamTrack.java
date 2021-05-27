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
public @interface ParamTrack {

    // 参数类（用来传递加密数据,只有方法参数中有此类或此类的子类才会执行加解密）
    Class value() ;

    // 参数类中传递加密数据的属性名，默认encryptStr
    String encryptStrName() default "encryptStr";
}
