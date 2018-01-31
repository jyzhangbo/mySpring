package com.github.javaconfig.bean;

/**
 * zhangbo
 */
public class JavaCdPlay {

    private JavaCdBean bean;

    public JavaCdPlay(JavaCdBean bean){
        this.bean=bean;
    }

    public void play(){
        bean.play();
    }

}
