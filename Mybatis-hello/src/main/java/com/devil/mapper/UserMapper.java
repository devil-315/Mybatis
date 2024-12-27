package com.devil.mapper;

import com.devil.entity.User;

import java.util.List;

/**
 * ClassName：UserDao
 *
 * @author: Devil
 * @Date: 2024/9/9
 * @Description:
 * @version: 1.0
 */
//数据库接口层
public interface UserMapper {
    //查询所有用户
    List<User> getUserList();

    //根据 id 查询
    User getUserById(int id);

    //新增
    int addUser(User user);

    //修改
    int updateUser(User user);

    //删除
    int deleteUser(int id);

    //模糊查询
    List<User> getUserLike(String name);
}
