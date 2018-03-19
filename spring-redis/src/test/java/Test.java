import com.github.config.MyConfig;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.awt.*;

/**
 * zhangbo
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyConfig.class)
public class Test {

    @Autowired
    private RedisConnectionFactory factory;

    @Autowired
    private RedisTemplate template;

    @org.junit.Test
    public void test(){
        RedisConnection connection = factory.getConnection();
        System.out.println(new String(connection.get("name".getBytes())));
    }

    @org.junit.Test
    public void testSave(){
        template.opsForValue().set("age","11");
    }

    @org.junit.Test
    public void testTemp(){
        Object name = template.opsForValue().get("age");

        System.out.println(name);
    }
}
