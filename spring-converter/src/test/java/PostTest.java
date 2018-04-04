import com.github.root.model.User;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * zhangbo
 */
public class PostTest {
    
    @Test
    public void postForObjectTest(){
        RestTemplate template=new RestTemplate();
        User user=new User();
        user.setId(1);
        user.setName("aaa");
        user.setAddress("bbb");
        List users = template.postForObject("http://localhost:8080/user",user,List.class);
        users.forEach(user1 -> System.out.println(user1.toString()));
    }

    @Test
    public void postForEntityTest(){
        RestTemplate template=new RestTemplate();
        User user=new User();
        user.setId(1);
        user.setName("aaa");
        user.setAddress("bbb");
        ResponseEntity<User> entity = template.postForEntity("http://localhost:8080/save", user, User.class);
        HttpStatus statusCode = entity.getStatusCode();
        System.out.println(statusCode.toString());
        System.out.println(entity.getBody().toString());
    }

    @Test
    public void postForLocalTest(){
        RestTemplate template=new RestTemplate();
        User user=new User();
        user.setId(1);
        user.setName("aaa");
        user.setAddress("bbb");
        String s = template.postForLocation("http://localhost:8080/save", user).toString();
        System.out.println(s);
    }


}
