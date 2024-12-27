import com.devil.entity.Person;
import com.devil.mapper.PersonMapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import static com.mysql.cj.protocol.a.MysqlTextValueDecoder.getTime;

/**
 * ClassName：PersonTest
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public class PersonTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        int i = mapper.addPerson(new Person(1, "haha", "456321", new Date(new java.util.Date().getTime())));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person query = mapper.query(4);
        System.out.println(query);
        sqlSession.close();
    }

    @Test
    public void tet03(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("startIndex",0);
        hashMap.put("pageSize",3);
        List<Person> personByLimit = mapper.getPersonByLimit(hashMap);
        for (Person person :
                personByLimit) {
            System.out.println(person);
        }
        sqlSession.close();
    }

    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        Person devil = mapper.getPersonByName("devil");
        System.out.println(devil);
        sqlSession.close();
    }

    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
        List<Person> person = mapper.getPerson(0, 3);
        for (Person person1 :
                person) {
            System.out.println(person);
        }
        sqlSession.close();
    }
}
