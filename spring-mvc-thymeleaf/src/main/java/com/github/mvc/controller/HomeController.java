package com.github.mvc.controller;

import com.github.mvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping(value = "regist",method = RequestMethod.GET)
    public String regist(Model model){
        model.addAttribute("user",new User());
        return "regist";
    }

    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public String registPost(@Valid User user, BindingResult errors){
        if(errors.hasErrors()){
            return "regist";
        }
        return "redirect:/home";
    }
}
