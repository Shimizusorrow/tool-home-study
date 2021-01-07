package com.example.mybatis.dao;

import com.example.mybatis.domain.Student;
import com.example.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-07 15:05
 */
public class StudentDao {
    public void add(Student student) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        try {
            sqlSession.insert("add", student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.close();
            throw e;
        }finally {
            MybatisUtil.closeSqlSession();
        }

    }

    public Student findById(Integer id){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        try {
           return sqlSession.selectOne("findById",id);
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.close();
            throw e;
        }finally {
            MybatisUtil.closeSqlSession();
        }
    }
}
