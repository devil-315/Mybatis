import com.devil.entity.User;
import com.devil.mapper.UserMapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

/**
 * ClassName：Test
 *
 * @author: Devil
 * @Date: 2024/9/9
 * @Description:
 * @version: 1.0
 */
public class test {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.add(new User(7, "大魔王", "520"));
        if(i > 0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(8);
        if(delete > 0 ){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int lisi = mapper.update(new User(3, "lisi", "5201314"));
        if(lisi > 0){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User select = mapper.select(3);
        System.out.println(select);
    }
}
