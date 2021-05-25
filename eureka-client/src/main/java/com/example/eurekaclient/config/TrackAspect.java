package com.example.eurekaclient.config;

import com.alibaba.fastjson.JSON;
import com.example.eurekaclient.Util.IpUtil;
import com.example.eurekaclient.annotation.TestTrack;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author hzx
 */
@Aspect//这个注解的作用是:将一个类定义为一个切面类
@Component//这个注解的作用：把切面类加入到IOC容器中
@Order(1)//这个注解的作用是:标记切面类的处理优先级,i值越小,优先级别越高.PS:可以注解类,也能注解到方法上
public class TrackAspect {


    private static final Logger log = LoggerFactory.getLogger(TrackAspect.class);


    @Pointcut(value = "@annotation(com.example.eurekaclient.annotation.TestTrack)")   //这个是将自己自定义注解作为切点的根据
    private  void access() {
    }

    @Before(value = "access()")
    public void doBefore(JoinPoint joinPoint){
        log.info("---aop 自定义注解启动(before)---"  +  new Date());
    }


    @Around("@annotation(testTrack)")     //环绕增强，是在before前就会触发
    public Object around(ProceedingJoinPoint pjp, TestTrack testTrack) throws Throwable {
        System.out.println("-aop 日志环绕阶段-" + new Date());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        GET 请求其实可以从request里获取出参数
//       Map<String,String[]> map=request.getParameterMap();
//        System.out.println("获取参数："+map.get("username")[0])

        String url = request.getRequestURL().toString();
        String ip = IpUtil.getIpAddr(request);
        String logTrackValue = testTrack.value();
        Object[] pipArray = pjp.getArgs();
        if (pipArray.length>1){
            //多参,不是Map/JsonObject方式
            List<Object> argList = new ArrayList<>();
            for (Object arg : pjp.getArgs()) {
                // request/response无法使用toJSON
                if (arg instanceof HttpServletRequest) {
                    argList.add("request");
                } else if (arg instanceof HttpServletResponse) {
                    argList.add("response");
                } else {
                    argList.add(JSON.toJSON(arg));
                }
            }
            Signature signature = pjp.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            // 参数名数组
            String[] parameterNames = ((MethodSignature) signature).getParameterNames();
            System.out.println("参数名数组："+new ArrayList(Arrays.asList(parameterNames)));
            System.out.println("参数是："+argList.toString());
            System.out.println("logTrackValue:"+logTrackValue);
            System.out.println("url:"+url);
            System.out.println("ip:"+ip);
            return pjp.proceed();
        }
        Object param =  pipArray[0];
        System.out.println("logTrackValue:"+logTrackValue);
        System.out.println("url:"+url);
        System.out.println("ip:"+ip);
        System.out.println("param:"+param.toString());
        return pjp.proceed();

    }



    @After("access()")  //进来切点这，最后经过的一个站，也是方法正常运行结束后
    public void after(JoinPoint joinPoint) {
        System.out.println("-aop 日志记录结束-" + new Date());
    }

















}
