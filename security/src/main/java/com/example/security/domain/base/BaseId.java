package com.example.security.domain.base;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Shimizu
 * @description Id
 * @date 2021-01-29 10:52
 */
@MappedSuperclass
public abstract class BaseId implements Serializable {
    @Id
    @GenericGenerator(name = "baseIdGenerator", strategy = "uuid")
    @GeneratedValue(generator = "baseIdGenerator")
    private String id;

    /**
     * 空构造器 序列化
     */
    public BaseId() {
    }

    public BaseId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseId baseId = (BaseId) o;
        return Objects.equals(id, baseId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
