package com.github.spel.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Component
public class Song {

    @Value("#{'dajiahao'}")
    public  String name;

    @Value("#{200}")
    public  Long length;

    public List<Singer> singers;

    public Song(){
        singers=new ArrayList<>();
        singers.add(new Singer("周杰伦",29));
        singers.add(new Singer("王力宏",39));
        singers.add(new Singer("林俊杰",49));
        singers.add(new Singer("刘德华",59));
    }



}
