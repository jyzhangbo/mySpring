import com.github.config.DbConfig;
import com.github.db.Order;
import com.github.repository.OrderRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.test.annotation.SystemProfileValueSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DbConfig.class)
public class Test {

    @Autowired
    private MongoOperations mongo;

    @org.junit.Test
    public void test(){
        System.out.println(mongo.getCollection("order").count());
    }

    @org.junit.Test
    public void testSave(){
        Order order=new Order();
        order.setId(2);
        order.setCustom("shanghai");
        order.setType("dizhi");
        mongo.save(order,"order");
    }

    @org.junit.Test
    public void findOne(){
        Order order=mongo.findById(2,Order.class);
        System.out.println(order.getCustom());
    }

}
