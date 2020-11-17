package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.Random;

/**
 * 学生实体
 *
 * @author shimizu
 * @date 2020年11月17日11:42:42
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity {

    private String name;

    private String gender;

    /**
     * 普通构造器
     *
     * @param name
     * @param gender
     */
    public Student(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

}
