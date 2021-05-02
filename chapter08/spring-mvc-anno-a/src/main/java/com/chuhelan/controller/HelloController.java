package com.chuhelan.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 11:07
 **/

public class HelloController {
    //真实访问地址 : 项目名/HelloController/hello

    @RequestMapping("/hello")
    public String sayHello(Model model) {
//向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg", "hello,SpringMVC");
//返回视图位置web-inf/jsp/hello.jsp
        return "hello";
    }
}
