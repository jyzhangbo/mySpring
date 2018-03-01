package com.github.web.content;

import com.github.web.exception.UserAddressException;
import com.github.web.exception.UserNameException;
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
