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
public class SendTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test1(){
        User user=new User();
        user.setId(1);
        user.setName("zhangbo");
        rabbitTemplate.convertAndSend("zhangbo","com.github.queue2",user);
        try {
            Thread.sleep(100000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test(){
        rabbitTemplate.convertAndSend("zhangbo","com.github.queue2","hello world");
        try {
            Thread.sleep(100000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
