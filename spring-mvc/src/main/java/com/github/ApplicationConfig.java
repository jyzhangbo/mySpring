package com.github;

import com.github.global.RootConfig;
import com.github.root.MvcConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * zhangbo
 */
public class ApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        //此处应该使用绝对路经
        registration.setMultipartConfig(new MultipartConfigElement("C:/temp/"));
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
