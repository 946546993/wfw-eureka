package com.example.eurekaclient.config;

import com.alibaba.fastjson.JSON;
import com.example.eurekaclient.Comment.Result;
import com.example.eurekaclient.annotation.ParamTrack;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author hzx
 */
@Aspect
@Component
@Slf4j
public class ParamTrackAspect {

    // 是否进行加密解密，通过配置文件注入（不配置默认为true）
    @Value("${isSecret:true}")
    boolean isSecret;

    @Pointcut(value = "@annotation(com.example.eurekaclient.annotation.ParamTrack)")
    private void paramTrack() {
    }


    @Before(value = "paramTrack()")
    public void doBefore() {
        log.info("================参数操作 aop  before===========");
    }

    @Around(value = "paramTrack()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        Result<Object> result = new Result();


        log.info("=========================  doAround  ===============================");
        Object[] args = joinPoint.getArgs();
        log.info("入参：" + Arrays.toString(args));
        //获取被代理对象
        Object target = joinPoint.getTarget();
        log.info("代理对象：" + target);
        // 获取通知签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        try {
            //获取被代理的方法
            Method pointMethod = target.getClass().getMethod(signature.getName(), signature.getParameterTypes());
            // 获取被代理方法(代理类)上面的注解@ParamTrack
            ParamTrack annotation = pointMethod.getAnnotation(ParamTrack.class) != null ?
                    pointMethod.getAnnotation(ParamTrack.class) : target.getClass().getAnnotation(ParamTrack.class);
            if (annotation != null) {
                //获取注解上生命的加密类
                Class clazz = annotation.value();
                // 获取注解上声明的加密参数名
                String encryptStrName = annotation.encryptStrName();
                for (int i = 0; i < args.length; i++) {
                    // 如果是clazz类型则说明使用了加密字符串encryptStr传递的加密参数
                    if (clazz.isInstance(args[i])) {
                        //将args[i]转换为clazz表示的类对象
                        Object cast = clazz.cast(args[i]);
                        // 通过反射，执行getEncryptStr()方法，获取加密数据
                        Method method = clazz.getMethod(getMethodName(encryptStrName));
                        // 执行方法，获取加密数据
                        String encryptStr = (String) method.invoke(cast);
                        // 加密字符串是否为空
                        if (StringUtils.isNotBlank(encryptStr)) {
                            // 加密
                            String json = "不会加密";
                            // 转换vo
                            args[i] = JSON.parseObject(json, (Type) args[i].getClass());
                        }
                    }
                }
            }
            // 执行请求
            result = (Result<Object>) joinPoint.proceed(args);

            // 判断配置是否需要返回加密
            if (isSecret) {
                // 获取返回值json字符串
                String jsonString = JSON.toJSONString(result.getData());
                // 解密
                String s = "不会解密";
                result.setData(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    /**
     *     转化方法名
     */
    private String getMethodName(String name) {
        String first = name.substring(0, 1);
        String last = name.substring(1);
        first = StringUtils.upperCase(first);
        return "get" + first + last;
    }


}
