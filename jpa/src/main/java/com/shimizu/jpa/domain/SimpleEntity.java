package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

/**
 * @author Shimizu
 * @description 简单类
 * @date 2020-12-08 09:24
 */
@Entity
public class SimpleEntity extends BaseEntity {

    private String rfid;
}
