package com.github.mvc.view.resovler;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

/**
 * zhangbo
 */
public class JsonViewResovler implements ViewResolver{
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        MappingJackson2JsonView view=new MappingJackson2JsonView();
        view.setPrefixJson(true);
        return view;
    }
}
