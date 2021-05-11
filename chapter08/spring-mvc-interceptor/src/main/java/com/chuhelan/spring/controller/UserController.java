package com.chuhelan.spring.controller;

import com.chuhelan.spring.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-11 09:36
 **/

@Controller
@RequestMapping("/userController")
public class UserController {

    /*向用户登录页面跳转*/
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (username != null && password != null && password.equals("123")) {
            session.setAttribute("user", user);
            return "redirect:main";
        }
        model.addAttribute("msg", "用户名或密码错误，请重新登录！");
        return "login";
    }

    @GetMapping("/main")
    public String toMain() {
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("2.UserController--->Handle被执行了");
        return "hello";
    }
}
