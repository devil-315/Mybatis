package com.devil.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName：Teacher
 *
 * @author: Devil
 * @Date: 2024/9/10
 * @Description:
 * @version: 1.0
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Teacher {
    private int tid;
    private String tname;
    private List<Student> students;
}
