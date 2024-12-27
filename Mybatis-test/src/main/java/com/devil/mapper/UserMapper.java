package com.devil.mapper;

import com.devil.entity.User;

/**
 * ClassName：UserMapper
 *
 * @author: Devil
 * @Date: 2024/9/9
 * @Description:
 * @version: 1.0
 */
public interface UserMapper {
    //增加
    int add(User user);
    //删除
    int delete(int id);
    //修改
    int update(User user);
    //查询
    User select(int id);
}
