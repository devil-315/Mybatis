package com.devil.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * ClassName：User
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Person {
    private int id;
    private String username;
    private String userPwd;
    private Date birthday;
}
