package com.chuhelan.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 10:02
 **/

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        //ModelAndView 模型和视图
        ModelAndView mav = new ModelAndView();
        //封装对象，放在ModelAndView中。Model
//        mav.addObject("msg", "HelloSpringMVC!");
        //封装要跳转的视图，放在ModelAndView中
        mav.setViewName("hello");
        //: /WEB-INF/jsp/hello.jsp
        return mav;
    }
}