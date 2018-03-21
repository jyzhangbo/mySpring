package com.github.mvc.controller;

import com.github.web.model.User;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public List<User> getUserById(@RequestBody User user){
        List<User> users=new ArrayList<>();
        users.add(user);
        return users;
    }

}
