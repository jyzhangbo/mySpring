package com.github.mvc.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * zhangbo
 */
public class User {

    @NotBlank(message = "name can not null")
    @Size(max = 20,min=2)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
