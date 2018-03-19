package com.github.service;

import com.github.model.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

/**
 * zhangbo
 */
@Service
public class CacheService {

    public static HashMap<Integer,User> map=new HashMap<>();

    @Cacheable(value = "user")
    public User getUserById(Integer id){
        System.out.println("查找数据");
        User s = map.get(id);
        return s;
    }

    @CachePut(value = "user",key = "#result.id",unless = "#result.address.equals('beijing')")
    public User save(User user){
        System.out.println("添加数据");
        map.put(user.getId(),user);
        return user;
    }

    @CacheEvict(value = "user")
    public void remove(Integer id){
        System.out.println("移除数据");
        map.remove(id);
    }
}
