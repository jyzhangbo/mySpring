package com.github;

import com.github.value.ValuePlaceholderConfig;
import com.github.value.bean.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ValuePlaceholderConfig.class)
public class ValueTest2 {

    @Autowired
    private Address address;

    @Test
    public void test(){
        System.out.println(address.toString());
    }
}
