package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author shimizu
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEntity {
    private String name;

    private String gender;

    public Teacher(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
