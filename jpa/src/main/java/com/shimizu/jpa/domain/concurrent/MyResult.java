package com.shimizu.jpa.domain.concurrent;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:12
 */
@NoArgsConstructor
@Entity
@Getter
@Setter
public class MyResult extends BaseEntity {
    private String name;
    private Integer count;

    public MyResult(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public void addCount() {
        this.count = count + 1;
    }
}
