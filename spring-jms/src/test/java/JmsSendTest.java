import com.github.config.JmsConfig;
import com.github.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JmsConfig.class)
public class JmsSendTest {

    @Autowired
    private JmsOperations operations;


    @Test
    public void test3(){
        User user=new User();
        user.setId(3);
        user.setName("zhangbo3");
        user.setAddress("beijing3");
        operations.convertAndSend(user);
        try {
            Thread.sleep(1000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        User user=new User();
        user.setId(2);
        user.setName("zhangbo2");
        user.setAddress("beijing2");
        operations.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });
    }


    @Test
    public void test1(){
        User user=new User();
        user.setId(1);
        user.setName("zhangbo");
        user.setAddress("beijing");
        operations.send("spring.test1", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(user);
            }
        });
    }

}
