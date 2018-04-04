package com.github.root.controller;

import com.github.root.exception.UserAddressException;
import com.github.root.exception.UserNameException;
import com.github.root.model.User;
import com.github.root.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String registPost(@RequestPart("picture") MultipartFile picture, @Valid User user, Errors error) throws IOException {
        if(error.hasErrors()){
            return "regist";
        }

        String reg="[a-zA-Z]{1,}";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(user.getAddress());
        if(!matcher.matches()){
            throw new UserAddressException();
        }

        System.out.println(picture.getName());
        File file=new File("D:/home/"+picture.getOriginalFilename());
        picture.transferTo(file);
        user=userService.save(user);
        return "redirect:/user/"+user.getId();
    }

    @RequestMapping(value = "/{id}")
    public String detail(@PathVariable(value = "id") Integer id,Model model){
        User user = userService.getById(id);
        if(user.getName().equals("123")){
            throw new UserNameException();
        }
        model.addAttribute("user",user);
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
