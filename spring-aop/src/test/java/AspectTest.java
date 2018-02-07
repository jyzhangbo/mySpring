import com.github.aop.AspectConfig;
import com.github.aop.aspect.ParamAspect;
import com.github.aop.bean.Encoreable;
import com.github.aop.bean.impl.EatSomething;
import com.github.aop.bean.impl.LunchEat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AspectConfig.class)
public class AspectTest {

    @Autowired
    private LunchEat eat;

    @Autowired
    private EatSomething eatSomething;

    @Autowired
    private ParamAspect aspect;

    @Test
    public void test2(){
        eat.eat();
        Encoreable encoreable = (Encoreable)eat;
        encoreable.eatSometing("玉米");
    }

    @Test
    public void test1(){
        eatSomething.eatSometing("apple");
        eatSomething.eatSometing("apple");
        eatSomething.eatSometing("cake");
        eatSomething.eatSometing("apple");
        eatSomething.eatSometing("cake");
        eatSomething.eatSometing("apple");
        eatSomething.eatSometing("apple");
        eatSomething.eatSometing("apple");

        System.out.println(aspect.getCount("apple"));
        System.out.println(aspect.getCount("cake"));
    }


    @Test
    public void test(){
        eat.eat();
    }


}
