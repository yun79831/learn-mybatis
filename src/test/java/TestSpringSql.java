import com.learn.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 集成式
 * Created by ghost on 2018-04-11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring-context.xml")
@Transactional
public class TestSpringSql {
    @Autowired
    private TestMapper testMapper;
    @Test
    public void test1() {
        com.learn.mybatis.beans.Test test= testMapper.selectByPrimaryKey(2);
        System.out.println(test.getName());
    }
}
