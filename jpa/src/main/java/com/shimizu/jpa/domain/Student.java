package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

    private String schoolNumber;


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

    public Student(String name, String gender, String schoolNumber) {
        this.name = name;
        this.gender = gender;
        this.schoolNumber = schoolNumber;
    }
}
