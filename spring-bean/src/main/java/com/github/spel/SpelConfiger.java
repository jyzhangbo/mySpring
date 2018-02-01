package com.github.spel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * zhangbo
 */
@Configuration
@ComponentScan
@PropertySource("value.properties")
public class SpelConfiger {

}
