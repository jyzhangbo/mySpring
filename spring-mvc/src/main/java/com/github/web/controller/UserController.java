package com.github.web.controller;

import com.github.web.model.User;
import com.github.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

/**
 * zhangbo
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/regist",method = RequestMethod.GET)
    public String regist(Model model){
        model.addAttribute("user",new User());
        return "regist";
    }

    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public String registPost(@Valid User user, Errors error){
        if(error.hasErrors()){
            return "regist";
        }
        user=userService.save(user);
        return "redirect:/user/"+user.getId();
    }

    @RequestMapping(value = "/{id}")
    public String detail(@PathVariable(value = "id") Integer id,Model model){
        model.addAttribute("user",userService.getById(id));
        return "detail";
    }

    @RequestMapping(value = "/list")
    public String list(@RequestParam(value = "count",defaultValue = Integer.MAX_VALUE+"") Integer count, Model model){
        model.addAttribute("users",userService.list(count));
        return "users";
    }

    @RequestMapping(value = "/list1")
    public String list1(Map model){
        model.put("users",userService.list(0));
        return "users";
    }

    @RequestMapping(value = "/list2")
    public String list2(Model model){
        model.addAttribute(userService.list(0));
        return "users2";
    }
}
