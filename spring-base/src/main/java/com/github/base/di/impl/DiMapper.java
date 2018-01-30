package com.github.base.di.impl;

import com.github.base.di.Mapper;

import java.io.PrintStream;

/**
 * zhangbo
 */
public class DiMapper implements Mapper {

    private PrintStream print;

    public DiMapper(PrintStream print){
        this.print=print;
    }

    public void add(){
        print.println("add");
    }
}
