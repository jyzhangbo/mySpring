package com.github;

import com.github.autowired.bean.CdBean;
import com.github.autowired.config.AutoConfiguration;
import com.github.autowired.service.CdPlayer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class) //可以创建spring的应用上下文
@ContextConfiguration(classes = AutoConfiguration.class)//指定配置类
public class AutoTest {

    @Autowired
    private CdBean bean;

    @Autowired
    private CdPlayer play;

    @Test
    public void testAuto() {
        Assert.assertNotNull(bean);

    }

    @Test
    public void testPlay() {
        play.cdPlay();
    }

}
