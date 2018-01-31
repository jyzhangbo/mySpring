package com.github.autowired.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * zhangbo
 */
@Configuration
@ComponentScan(basePackages = {"com.github.autowired.bean","com.github.autowired.service"})
public class AutoConfiguration {
}
