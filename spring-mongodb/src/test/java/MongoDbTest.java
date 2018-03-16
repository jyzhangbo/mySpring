import com.github.config.MongoDbConfig;
import com.github.db.Order;
import com.github.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoDbConfig.class)
public class MongoDbTest {

    @Autowired
    private OrderRepository repository;

    @Test
    public void test(){
        long count = repository.count();
        System.out.println(count);
    }

    @Test
    public void findByType(){
        List<Order> orders = repository.findByType("dizhi");
        orders.stream().forEach(order -> System.out.println(order.getCustom()));
    }

    @Test
    public void findOrdersByType(){
        List<Order> orders = repository.findOrdersByType("dizhi");
        orders.stream().forEach(order -> System.out.println(order.getCustom()));
    }
}
