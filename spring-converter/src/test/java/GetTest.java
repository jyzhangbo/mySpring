import com.github.web.model.User;
import org.junit.Test;
import org.omg.CORBA.INTERNAL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * zhangbo
 */
public class GetTest {

    @Test
    public void getForObjectTest(){
        RestTemplate template=new RestTemplate();
        List users = template.getForObject("http://localhost:8080/{id}", List.class, 1);
        users.forEach(user -> System.out.println(user.toString()));
    }

    @Test
    public void getForObjectTest1(){
        RestTemplate template=new RestTemplate();
        Map<String,Integer> map=new HashMap<>();
        map.put("id",1);
        List users = template.getForObject("http://localhost:8080/{id}", List.class, map);
        users.forEach(user -> System.out.println(user.toString()));
    }

    @Test
    public void getForEntity(){
        RestTemplate template=new RestTemplate();
        ResponseEntity<?> forEntity = template.getForEntity("http://localhost:8080/user/{id}", Object.class, 1);
        HttpStatus statusCode = forEntity.getStatusCode();
        System.out.println(statusCode.toString());


    }

}
