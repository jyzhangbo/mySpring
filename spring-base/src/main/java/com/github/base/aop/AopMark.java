package com.github.base.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.PrintStream;

/**
 * zhangbo
 */
public class AopMark {

    private PrintStream stream;

    public AopMark(PrintStream stream){
        this.stream=stream;
    }

    public void beforeAddMark(){
        stream.println("before");
    }

    public void afterAddMark(){
        stream.println("after");
    }

}
