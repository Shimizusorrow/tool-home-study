package com.shimizu.jpa.domain.concurrent;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:01
 */
@NoArgsConstructor
@Entity
@Getter
@Setter
public class MyCondition extends BaseEntity {
    private String name;
    private String model;

    public MyCondition(String name, String model) {
        this.name = name;
        this.model = model;
    }
}
