package com.github.root.model;

/**
 * zhangbo
 */
public class NotFoundException extends RuntimeException{

    private Integer id;

    public NotFoundException(Integer id){
        this.id=id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
