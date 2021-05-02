package com.chuhelan.controller;

import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 11:07
 **/

public class HelloController {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","springMVC");
        return "hello";
    }
}