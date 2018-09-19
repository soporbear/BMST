package com.lilin;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if(url.contains("login")||url.contains("resources")){
            return true;
        }

        HttpSession session  = request.getSession();
        if(session.getAttribute("isAdmin")=="true") {
            return true;
        }

        response.setHeader("location", "/login");
        response.setStatus(302);

        return false;
    }
}
