import com.github.config.AmqpConfig;
import com.github.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AmqpConfig.class)
public class ReceiveTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test1(){
        User o =(User) rabbitTemplate.receiveAndConvert("queue1");
        System.out.println(o.toString());
    }

    @Test
    public void test(){
        Object o = rabbitTemplate.receiveAndConvert("queue2");
        System.out.println(o.toString());
    }

}
