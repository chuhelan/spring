package com.chuhelan.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 09:20
 **/
@Configuration
//启动AspectJ代理
@EnableAspectJAutoProxy
@ComponentScan("com.chuhelan")
public class HelloConfig {
}
