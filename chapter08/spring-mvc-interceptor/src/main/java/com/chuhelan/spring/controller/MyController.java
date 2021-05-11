package com.chuhelan.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-11 09:28
 **/

@Controller
@RequestMapping("/myController")
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        System.out.println("2.MyController--->Handle被执行了");
        return "hello";
    }

    @GetMapping("/my")
    @ResponseBody
    public ResponseEntity my(Model model){
        String intercValue = (String) model.getAttribute("MyInterceptor");
        String result = "MyController...Handle";
        System.out.println("MyController...Handle");
        return ResponseEntity.ok(result+intercValue);
    }
}
