import com.devil.entity.User;
import com.devil.mapper.Mapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName：MybatisTest
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public class MybatisTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        Mapper mapper = sqlSession.getMapper(Mapper.class);
        List<User> userList = mapper.getUserList();
        for (User user :
                userList) {
            System.out.println(user);
        }
    }
}
