package com.shimizu.jpa.domain;

import com.shimizu.jpa.repo.ElementDomainRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("junit")
@ExtendWith(SpringExtension.class)
@Rollback(false)
class ElementDomainServiceTest {
    @Autowired
    private ElementDomainRepository elementDomainRepository;

    @Test
    void notNull() {
        assertNotNull(elementDomainRepository);
    }

    @Test
    void add() {
        List<ElementType> list = new ArrayList<>();
        list.add(new ElementType("1"));
        list.add(new ElementType("2"));
        elementDomainRepository.save(new ElementDomain("测试1", list));

        List<ElementType> list2 = new ArrayList<>();
        list2.add(new ElementType("1"));
        list2.add(new ElementType("2"));
        elementDomainRepository.save(new ElementDomain("测试2", list2));
    }

    @Test
    void find2() {
        List<ElementDomain> list = elementDomainRepository.findByList("3");
        list.forEach(it -> {
            System.out.println(it.getName());
            it.getList().forEach(
                    i -> {
                        System.out.println(i.getRfId());
                    }
            );
            System.out.println("---");
        });
        elementDomainRepository.delete(list.get(0));
    }

    @Test
    void find() {
        assertEquals("测试1", elementDomainRepository.findByName("测试1").getName(), "查询结果不符合");
    }

    @Test
    void remove() {
        ElementDomain elementDomain = elementDomainRepository.findByName("测试1");
        elementDomain.getList().remove("1");
    }
}