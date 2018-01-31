package com.github;

import com.github.profile.ProfileConfiger;
import com.github.profile.bean.MyDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfiger.class)
@ActiveProfiles("prod")
public class ProfileTest {

    @Autowired
    MyDataSource dataSource;

    @Test
    public void test1(){
        dataSource.run();
    }
}
