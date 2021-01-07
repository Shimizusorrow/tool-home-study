package com.example.mybatis.domain;

import io.swagger.models.auth.In;

/**
 * @author Shimizu
 * @description 学生
 * @date 2021-01-07 13:49
 */
public class Student {
    private Integer id;
    private String name;
    private Double sal;

    public Student() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }
}
