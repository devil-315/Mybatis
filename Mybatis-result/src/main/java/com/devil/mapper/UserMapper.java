package com.devil.mapper;

import com.devil.entity.User;

/**
 * ClassName：UserMapper
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
public interface UserMapper {
    User getUserById(int uid);
}
