package com.lilin.controller;

import com.lilin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginController {
    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("")
    public String login() {
        return "login";
    }

    @ResponseBody
    @RequestMapping("check")
    public String check(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(userService.userCheck(request.getParameter("userName"), request.getParameter("password")));
        if(userService.userCheck(request.getParameter("userName"), request.getParameter("password"))!=null) {
            session.setAttribute("isAdmin", "true");
            return "true";
        }
        else {
            return "false";
        }
    }
}
