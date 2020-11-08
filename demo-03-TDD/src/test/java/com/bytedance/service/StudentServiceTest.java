package com.bytedance.service;

import com.bytedance.dao.StudentDao;
import com.bytedance.domain.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {

    @Test
    void getStudentById() {

        //Given 首先mock类
        StudentDao studentDao = Mockito.mock(StudentDao.class);


        //When
        Mockito.when(studentDao.getStudentById(3)).thenReturn(new Student("李四",19));

        //Then
        StudentService studentService = new StudentService(studentDao);
        Student studentById = studentService.getStudentById(3);


        //Assert
        Assertions.assertEquals(studentById.getName(), "李四");
        Assertions.assertEquals(studentById.getAge(), 19);
    }
}