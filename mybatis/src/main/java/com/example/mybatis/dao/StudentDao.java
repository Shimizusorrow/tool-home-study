package com.example.mybatis.dao;

import com.example.mybatis.domain.Student;
import com.example.mybatis.util.MybatisUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-07 15:05
 */
//@Mapper
public class StudentDao {
    public void add(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.insert("Student.add", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.close();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }

    }

    public Student findById(Integer id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            return sqlSession.selectOne("Student.findById", id);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.close();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }

    public List<Student> findAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            return sqlSession.selectList("Student.findAll");
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.close();
            throw e;
        } finally {
            MybatisUtil.closeSqlSession();
        }
    }
}
