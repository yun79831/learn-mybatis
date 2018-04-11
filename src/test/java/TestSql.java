import com.learn.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 编程式mybatis
 * Created by ghost on 2018-04-11.
 */
public class TestSql {
    @Test
    public void test1() throws FileNotFoundException {
        TestMapper mapper = getSqlSession().getMapper(TestMapper.class);
        com.learn.mybatis.beans.Test test= mapper.selectByPrimaryKey(2);
        System.out.println(test.getName());
    }


    //获取SqlSession
    public static SqlSession getSqlSession() throws FileNotFoundException {
        InputStream mybatisConfig = new FileInputStream("E:\\workspace\\learn-mybatis\\src\\main\\resources\\mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfig);
        return sqlSessionFactory.openSession();
    }

    public static void main(String[] args) throws FileNotFoundException {
    }
}
