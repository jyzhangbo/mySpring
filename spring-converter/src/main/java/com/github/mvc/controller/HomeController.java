package com.github.mvc.controller;

import com.github.web.model.Error;
import com.github.web.model.NotFoundException;
import com.github.web.model.User;
import com.sun.net.httpserver.HttpsConfigurator;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * zhangbo
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @ResponseBody
    public List<User> add(@RequestBody User user){
        List<User> users=new ArrayList<>();
        users.add(user);
        return users;
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user, UriComponentsBuilder builder){
        HttpHeaders headers=new HttpHeaders();
        URI uri=builder.path(String.valueOf(user.getId())).build().toUri();
        headers.setLocation(uri);
        ResponseEntity<User> entity=new ResponseEntity<>(user,headers,HttpStatus.CREATED);

        return entity;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserById(@PathVariable Integer id){
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setId(1);
        user.setName("aaa");
        user.setAddress("bbb");
        users.add(user);

        List<User> userList = users.stream().filter(obj -> obj.getId().equals(id)).collect(Collectors.toList());
        return userList;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getUserById2(@PathVariable Integer id){
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setId(1);
        user.setName("aaa");
        user.setAddress("bbb");
        users.add(user);
        List<User> userList = users.stream().filter(obj -> obj.getId().equals(id)).collect(Collectors.toList());

        if(userList.isEmpty()){
            return new ResponseEntity<>(new Error(404,"not found "+id),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @RequestMapping(value = "/user3/{id}",method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserById3(@PathVariable Integer id){
        List<User> users=new ArrayList<>();
        User user=new User();
        user.setId(1);
        user.setName("aaa");
        user.setAddress("bbb");
        users.add(user);
        List<User> userList = users.stream().filter(obj -> obj.getId().equals(id)).collect(Collectors.toList());

        if(userList.isEmpty()){
            throw new NotFoundException(id);
        }

        return userList;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public Error notFound(NotFoundException e){
        return new Error(404,"not found "+e.getId());
    }

}
