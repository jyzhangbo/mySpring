package com.github.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * zhangbo
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "名字格式不对")
public class UserNameException extends RuntimeException{
}
