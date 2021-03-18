package com.chuhelan.advice;

import com.chuhelan.aspect.MyAspect;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import java.lang.annotation.Target;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-18 14:30
 **/

public class MyUserAdvice {

    private Logger logger = LogManager.getLogger(MyAspect.class);
    //    前置通知
    public void before(JoinPoint jp){
        logger.info("前置通知：模拟权限检查.......");
        logger.info("目标类："+jp.getTarget()+"，植入的目标方法："+jp.getSignature().getName());
    }
    //  后置通知
    public void after(JoinPoint jp){
        logger.info("后置通知：关闭数据库资源.......");
        logger.info("目标类："+jp.getTarget()+"，植入的目标方法："+jp.getSignature().getName());
    }

}