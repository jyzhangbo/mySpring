import com.github.config.CacheConfig;
import com.github.model.User;
import com.github.service.CacheService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CacheConfig.class)
public class Test {

    @Autowired
    private CacheService service;

    @org.junit.Test
    public void test(){
        User user=new User();
        user.setId(1);
        user.setName("zhangbo");
        user.setAddress("beijing");

        service.save(user);//unless为true，不放入缓存

        User user1 = service.getUserById(1);//调用方法获取数据，并放入缓存
        System.out.println(user1.toString());

        User user2=service.getUserById(1);//直接从缓存中获取
        System.out.println(user2.toString());

        service.remove(1);

        User user3 = service.getUserById(1);
        System.out.println(user3.toString());
    }

}
