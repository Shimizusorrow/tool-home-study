package com.shimizu.jpa.domain.complex;

import com.shimizu.jpa.domain.base.BaseEntity;

import javax.persistence.Entity;

/**
 * @author Shimizu
 * @description 椅子
 * @date 2020-12-09 17:00
 */
@Entity
public class Chair extends BaseEntity {
    /**
     * 椅子名称
     */
    private String name;
}
