package com.bytedance.service;

import com.bytedance.dao.StudentDao;
import com.bytedance.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }
}
