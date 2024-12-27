import com.devil.entity.User;
import com.devil.mapper.UserMapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName：UserTest
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public class UserTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
        sqlSession.close();
    }
}
