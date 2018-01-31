package com.github;

import com.github.ambiguity.Dessert;
import com.github.ambiguity.DessertConfig;
import com.github.ambiguity.annotation.Cream;
import com.github.ambiguity.annotation.Ice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertConfig.class)
public class DessertTest {

    @Autowired
    @Cream
    Dessert dessert;

    @Test
    public void test() {
        dessert.run();
    }

}
