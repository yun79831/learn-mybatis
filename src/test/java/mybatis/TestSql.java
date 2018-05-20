package mybatis;

import com.learn.mybatis.beans.Author;
import com.learn.mybatis.config.IntegrationMyBatisConfiguration;
import com.learn.mybatis.mapper.AuthorMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by ghost on 2018-04-11.
 */
public class TestSql {

    @Test
    public void test1() throws FileNotFoundException {
        SqlSession sqlSession = IntegrationMyBatisConfiguration.getSqlSession();
        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
        Author author = mapper.selectByPrimaryKey(2);
        System.out.println(author.getAuthorName());
        sqlSession.close();
    }

    @Test
    public void testTypeHandler() throws FileNotFoundException {
        SqlSession sqlSession = IntegrationMyBatisConfiguration.getSqlSession();
        AuthorMapper mapper = sqlSession.getMapper(AuthorMapper.class);
        Author author = new Author();
        author.setAuthorName("测试1");
        mapper.insert(author);
        sqlSession.commit();
        sqlSession.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
    }
}
