package com.github.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @RequestMapping({"/","home"})
    public String home(){
        return "home";
    }
}
