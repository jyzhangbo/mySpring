package com.github;

import com.github.spel.SpelConfiger;
import com.github.spel.bean.CD;
import com.github.spel.bean.Circle;
import com.github.spel.bean.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 启动的时候需要添加-Dcompany.address 参数配置，systemProperties才能获取到值
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpelConfiger.class)
public class SpelTest {

    @Autowired
    private Company company;

    @Autowired
    private Circle circle;

    @Autowired
    @Qualifier("cd")
    private CD cD;

    @Test
    public void test3() {
        cD.singers.forEach(sing -> System.out.println(sing.toString()));
        System.out.println(cD.firstSinger);
        System.out.println(cD.lastSinger);
        cD.names.forEach(name -> System.out.println(name));
        System.out.println(cD.lastName);
    }

    @Test
    public void test2() {
        System.out.println(circle.zhouchang);
        System.out.println(circle.mianji);
    }

    @Test
    public void test() {
        System.out.println(company.toString());
    }

}
