package com.bytedance.dao;

import com.bytedance.domain.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {
    public Student getStudentById(int id){
        return new Student("张三",18);
    }
}
