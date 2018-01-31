package com.github;

import com.github.javaconfig.bean.JavaCdBean;
import com.github.javaconfig.bean.JavaCdPlay;
import com.github.javaconfig.config.JavaConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfiguration.class)
public class JavaConfigTest {

    @Autowired
    JavaCdBean bean;

    @Autowired
    JavaCdPlay play;

    @Test
    public void javaConfig(){
        Assert.assertNotNull(bean);
    }

    @Test
    public void javaT(){
        play.play();
    }

}
