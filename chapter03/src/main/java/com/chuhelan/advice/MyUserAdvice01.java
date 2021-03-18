package com.chuhelan.advice;

import com.chuhelan.aspect.MyAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-18 14:30
 **/


@Aspect
@Component
public class MyUserAdvice01 {
    private Logger logger = LogManager.getLogger(MyAspect.class);

//    定义切点表达式
    @Pointcut("execution(* com.chuhelan.jdk.UserDaoImpl.*(..))")
    private void myCut(){

    }
    //    前置通知
    @Before("myCut()")
    public void before(JoinPoint jp){
        logger.info("前置通知：模拟权限检查.......");
        logger.info("目标类："+jp.getTarget()+"，植入的目标方法："+jp.getSignature().getName());
    }
    //  后置通知
    @AfterReturning("myCut()")
    public void after(JoinPoint jp){
        logger.info("后置通知：关闭数据库资源.......");
        logger.info("目标类："+jp.getTarget()+"，植入的目标方法："+jp.getSignature().getName());
    }

}