package com.chuhelan.spring.interceptor;

import com.chuhelan.spring.domain.User;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-11 09:37
 **/

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
//获取请求url
        String url = request.getRequestURI();
        /*放行login*/
        if (url.indexOf("/login") > 0) {
            return true;
        }
//获取session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return true;
        }
        request.setAttribute("msg", "您还未登录，请先登录!");
// response.sendRedirect("login"); //此样msg传递不过去
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler,
                modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws
            Exception {
        HandlerInterceptor.super.afterCompletion(request, response,
                handler, ex);
    }
}