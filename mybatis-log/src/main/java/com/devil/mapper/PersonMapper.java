package com.devil.mapper;

import com.devil.entity.Person;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * ClassName：PersonMapper
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public interface PersonMapper {
    int addPerson(Person person);

//    @Param():给参数命名
    //sql中引用的就是@Param()中设定的名字
    //如果是一个基本数据类型，可以忽略，但是建议加上
    Person query(@Param("uid") int id);

    Person getPersonByName(@Param("name") String username);
    List<Person> getPersonByLimit(HashMap<String,Integer> map);

    List<Person> getPerson(@Param("startIndex") int startIndex ,@Param("pageSize") int pageSize);
}
