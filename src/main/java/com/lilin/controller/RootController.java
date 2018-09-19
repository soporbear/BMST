package com.lilin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    @RequestMapping("")
    String manage() {
        return "redirect:/manage/article/";
    }

    @RequestMapping("manage")
    String article() {
        return "redirect:/manage/article/";
    }
}
