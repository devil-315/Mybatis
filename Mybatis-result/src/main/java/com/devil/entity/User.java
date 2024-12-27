package com.devil.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName：User
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int uid;
    private String username;
    private String userPwd;
}
