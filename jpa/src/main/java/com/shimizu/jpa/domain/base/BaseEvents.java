package com.shimizu.jpa.domain.base;

import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.MappedSuperclass;
import java.util.Set;

@MappedSuperclass
public interface BaseEvents {
    /**
     * 发布事件
     *
     * @param event
     */
    default void publishEvent(Object event) {
        if (event != null) {
            if (domainEvents() != null) {
                domainEvents().add(event);
            } else {
                throw new IllegalArgumentException("事件发布器为null");
            }
        }

    }

    /**
     * 获得要发布的领域事件。
     * 该接口会被 Spring Data JPA 、 Spring Data MongoDB 调用，用来发布领域事件。
     * 调用的时间为 领域模型仓储(Repository).save() 方法执行后调用。
     */
    @DomainEvents
    Set<Object> domainEvents();

    @AfterDomainEventPublication
    default void afterPublication() {
        Set<Object> events = domainEvents();
        if (events != null) {
            events.clear();
        }
    }
}
