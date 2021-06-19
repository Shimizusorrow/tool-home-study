package com.shimizu.jpa.domain.complex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("junitH2")
class ChairTest {
    @Autowired
    private EntityManager ENTITY_MANAGER;

    @Test
    void notNull() {
        assertNotNull(ENTITY_MANAGER);
    }

    @Test
    void test() {
        Chair chair = new Chair();
        chair.setName("张三");
        Chair chair2 = ENTITY_MANAGER.merge(chair);
        ENTITY_MANAGER.persist(chair2);
        String id = chair2.getId();
        System.out.println(id);
//        System.out.println(chair2.getId());
        Chair chair1 = ENTITY_MANAGER.find(Chair.class, id);
        System.out.println(chair1.getName());
        chair1.setName("李四");
        ENTITY_MANAGER.clear();
        Chair chair4 = ENTITY_MANAGER.find(Chair.class, id);

    }
}