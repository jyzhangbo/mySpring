package com.github.mvc.controller;

import com.github.web.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(Model model){
        User user=new User();
        user.setId(1);
        user.setName("zzz");
        user.setAddress("bbb");
        model.addAttribute("index",user);
        return "index";
    }

    @RequestMapping("/user")
    public List<User> getUserById(){
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setId(1);
        user.setName("zzz");
        user.setAddress("bbb");
        users.add(user);
        return users;
    }

}
