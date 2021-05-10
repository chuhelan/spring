package com.chuhelan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-10 15:24
 **/

@Controller
public class UserController {

    @RequestMapping("/selectUser")
    public String selectUser(Integer id){
        System.out.println("id="+id);
        return "success";
    }
}