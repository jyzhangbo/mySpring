package com.github;

import com.github.scope.ScopeConfig;
import com.github.scope.bean.PrototypeBean;
import com.github.scope.bean.SingletonBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScopeConfig.class)
public class ScopeTest implements ApplicationContextAware {

    @Autowired
    SingletonBean bean;

    @Autowired
    PrototypeBean bean1;

    @Test
    public void testSingleton() {
        bean.run();
        SingletonBean bean2 = context.getBean(SingletonBean.class);
        bean2.run();
    }

    @Test
    public void testPrototye(){
        bean1.run();
        PrototypeBean bean3 = context.getBean(PrototypeBean.class);
        bean3.run();

    }

    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
