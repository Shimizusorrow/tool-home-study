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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles
class StudentDaoTest {
    public static StudentDao studentDao;

    @Test
    @BeforeEach
    void test() {
        Connection conn = MybatisUtil.getSqlSession().getConnection();
        System.out.println(conn != null ? "连接成功" : "连接失败");
        studentDao = studentDao == null ? new StudentDao() : studentDao;
    }

    @Test
    void add() {
        Student student = new Student();
        student.setId(1);
        student.setName("hhh");
        student.setSal(Double.valueOf("23.2"));
        studentDao = new StudentDao();
        studentDao.add(student);
    }

    @Test
    void findById() {
        Student id = studentDao.findById(1);
        System.out.println(id.toString());
    }
}