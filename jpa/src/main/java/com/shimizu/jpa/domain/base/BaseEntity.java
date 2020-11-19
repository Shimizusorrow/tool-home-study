package com.shimizu.jpa.domain.base;


import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shimizu
 */
@MappedSuperclass
@Getter
@Setter
public class BaseEntity implements BaseEvents {
//public class BaseEntity  {
    @Id
    private String id;
    private long updateTime;
    private long createTime;

    @Transient
    private Set<Object> domainEvents;

    @PrePersist
    void initTime() {
        this.id = this.id == null ? generateId() : this.id;
        this.createTime = System.currentTimeMillis();
        this.updateTime = System.currentTimeMillis();
    }

    @PreUpdate
    void updateTime() {
        this.updateTime = System.currentTimeMillis();
    }

    private String generateId() {
        return String.format("%x", (int) (Math.random() * 999999)) + (int) (Math.random() * 99);
    }

    @Override
    public Set<Object> domainEvents() {
        return domainEvents =
                domainEvents == null ?
                        new HashSet<>() :
                        domainEvents;
    }
}
