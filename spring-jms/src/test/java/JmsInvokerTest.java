import com.github.config.JmsConfig;
import com.github.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JmsConfig.class)
public class JmsInvokerTest {

    @Autowired
    private TestService testService;

    @Test
    public void test(){
        testService.test();
    }

}
