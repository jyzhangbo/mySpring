package com.github;

import com.github.condition.ConditionConfiguration;
import com.github.condition.bean.ConditionDataSource;
import com.github.condition.bean.impl.DevDataSource;
import com.github.condition.bean.impl.ProdDataSource;
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
@ContextConfiguration(classes = ConditionConfiguration.class)
public class ConditionTest {

    @Autowired
    ConditionDataSource dataSource;

    @Test
    public void test(){
        dataSource.run();
    }
}
