import com.devil.entity.User;
import com.devil.mapper.UserMapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName：CacheTest
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public class CacheTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //TODO 第一次查询
        User user1 = mapper.getUserById(1);
        System.out.println(user1);

        //TODO 第二次查询
        User user2 = mapper.getUserById(1);
        System.out.println(user2);

        System.out.println("================");
        System.out.println(user1 == user2);

        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        //TODO 第一次查询
        User user1 = mapper.getUserById(1);
        System.out.println(user1);

        //修改
        int i = mapper.updateUser(new User(2, "abc", "123456"));
        System.out.println("====================");

        //TODO 第二次查询
        User user2 = mapper.getUserById(1);
        System.out.println(user2);

        System.out.println("================");
        System.out.println(user1 == user2);

        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper01 = sqlSession.getMapper(UserMapper.class);

        //TODO 第一次查询
        User user1 = mapper01.getUserById(1);
        System.out.println(user1);

        User user2 = mapper01.getUserById(1);
        System.out.println(user2);

        System.out.println(user1 == user2);

        sqlSession.close();

        //TODO 新开的sqlsession
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();
        UserMapper mapper02 = sqlSession2.getMapper(UserMapper.class);
        //TODO 第三次查询
        User user3 = mapper02.getUserById(1);
        System.out.println(user3);
        System.out.println(user3 == user1);

    }
}
