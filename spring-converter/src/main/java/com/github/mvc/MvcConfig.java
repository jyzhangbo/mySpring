package com.github.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * zhangbo
 */
@Configuration
@ComponentScan("com.github.mvc.controller")
public class MvcConfig extends WebMvcConfigurationSupport{



}
