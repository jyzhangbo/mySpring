package com.github.spel.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * zhangbo
 */
@Component
@Qualifier("cd")
public class CD {

    @Value("#{song.singers.?[age > 30]}")
    public List<Singer> singers;

    @Value("#{song.singers.^[age > 30]}")
    public Singer firstSinger;

    @Value("#{song.singers.$[age>30]}")
    public Singer lastSinger;

    @Value("#{song.singers.![name]}")
    public List<String> names;

    @Value("#{song.singers.?[age>30].![name]}")
    public List<String> lastName;

}
