package com.github.root.content;

import com.github.root.exception.UserAddressException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * zhangbo
 */
@ControllerAdvice
public class AdviceContent {

    @ExceptionHandler(UserAddressException.class)
    public String notFound(){
        return "error";
    }
}
