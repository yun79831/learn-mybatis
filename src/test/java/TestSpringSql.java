import com.learn.mybatis.beans.Author;
import com.learn.mybatis.mapper.AuthorMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
    private AuthorMapper authorMapper;

    @Test
    public void test1() {
        Author author = authorMapper.selectByPrimaryKey(2);
        System.out.println(author.getAuthorName());
    }
}
