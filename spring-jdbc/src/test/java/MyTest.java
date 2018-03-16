import com.github.jdbc.MyDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * zhangbo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyDataSource.class)
public class MyTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testTemplate(){
        String sql="insert into user (username,password,enabled) values (?,?,?)";
        jdbcTemplate.update(sql,"heweiwei","zhengzhou","1");
    }


    @Test
    public void test(){
        String sql="insert into user (username,password,enabled) values (?,?,?)";
        Connection connection=null;
        PreparedStatement statement=null;
        try{
            connection=dataSource.getConnection();
            statement=connection.prepareStatement(sql);
            statement.setString(1,"zhangbo");
            statement.setString(2,"beijing");
            statement.setInt(3,1);
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
