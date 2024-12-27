import com.devil.entity.User;
import com.devil.mapper.UserMapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * ClassName：MybastisUtil
 *
 * @author: Devil
 * @Date: 2024/9/9
 * @Description:
 * @version: 1.0
 */
public class MybastisTest {
    @Test
    public void test01() throws IOException {
        //1.构建SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //方式一：
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user :
                userList) {
            System.out.println(user);
        }

        System.out.println("================");
        List<User> list = sqlSession.selectList("com.devil.mapper.UserMapper.getUserList");
        for (User user :
                list) {
            System.out.println(user);
        }
    }

    @Test
    public void test02() throws IOException {
/*
        //1.构建SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
*/
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);
    }

    @Test
    public void tes03(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.addUser(new User(4, "哈哈", "123456"));

        if(i > 0){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }

        //TODO 提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(6, "haha", "654321"));

        if (i > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(6);
        if(i > 0 ){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test06(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> like = mapper.getUserLike("美");
        for (User user :
                like) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
