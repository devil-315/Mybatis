import com.devil.entity.Student;
import com.devil.mapper.StudentMapper;
import com.devil.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.List;

/**
 * ClassName：StudentTest
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public class StudentTest {
    @Test
    public void getStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentById = mapper.getStudentList();
        for (Student student :studentById) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
