package com.chuhelan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-10 16:33
 **/

@Controller
public class DateController {
    @RequestMapping("/customDate")
    public String CustomDate(Date date){
        System.out.println("date="+date);
        return "success";
    }
}