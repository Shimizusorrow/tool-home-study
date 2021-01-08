package com.example.mybatis.dao;

import com.example.mybatis.domain.Student;
import com.example.mybatis.util.MybatisUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles
class StudentDaoTest {


    @Test
    @BeforeEach
    void test() {
        Connection conn = MybatisUtil.getSqlSession().getConnection();
        System.out.println(conn != null ? "连接成功" : "连接失败");

    }

    @Test
    void add() {
        StudentDao studentDao = new StudentDao();
//        StudentMapper studentMapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        Student student = new Student();
        student.setId(112);
        student.setName("hhh2");
        student.setSal(Double.valueOf("23.2"));
        studentDao.add(student);
    }

    @Test
    void findById() {
        StudentDao studentDao = new StudentDao();
//        StudentMapper studentMapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        Student id = studentDao.findById(1);
        System.out.println(id.toString());
    }

    @Test
    void findAll() {
        StudentDao studentDao = new StudentDao();
//        StudentMapper studentMapper = MybatisUtil.getSqlSession().getMapper(StudentMapper.class);
        List<Student> all = studentDao.findAll();
        all.forEach(it -> System.out.println(it.getName()));
    }
}