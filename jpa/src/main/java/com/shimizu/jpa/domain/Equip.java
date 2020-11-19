package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import com.shimizu.jpa.event.EquipEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;

import javax.persistence.Entity;
import javax.persistence.PreUpdate;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Slf4j
public class Equip extends BaseEntity {
    private boolean state = false;

    @PreUpdate
    void publishUpdate() {
        log.info("更新成功");
        publishEvent(this);
    }

    @DomainEvents
    public void publish() {
        log.info("domainEvent 发布");
        publishEvent(new EquipEvent(this));
    }

    @AfterDomainEventPublication
    public void after() {
        publishEvent(new EquipEvent(this));
        log.info("afterDomainEvent 回调");
    }
//    public void publishSelf(){
//        publishEvent(this);
//    }

    void temp() {
//        equipRepo.save()
        // em.persist()
        // @PreUpdate 注解的方法
        //@DomainEvent 注解的方法
    }
}
