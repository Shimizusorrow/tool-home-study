package com.shimizu.jpa;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.Student;
import com.shimizu.jpa.domain.StudentItems;
import com.shimizu.jpa.domain.Teacher;
import com.shimizu.jpa.domain.box.EquipBox;
import com.shimizu.jpa.repo.EquipBoxRepo;
import com.shimizu.jpa.repo.EquipRepo;
import com.shimizu.jpa.repo.StuRepo;
import com.shimizu.jpa.repo.TeaRepo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.management.timer.Timer;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 启动部分Spring上下文
 */
@ExtendWith(SpringExtension.class)
/**
 * 使用JapTest
 */
@DataJpaTest
/**
 * 使用测试的配置
 */
@ActiveProfiles("junit")
/**
 * 执行的时候忽略
 */
//@Disabled
/**
 * 这个是防止 test下的包名和java 下的包名不一致导致无法认知的问题
 */
@ContextConfiguration(classes = {TestEquipBox.class})

/**
 * 这两个注解时为了将实体Domain 扫描到还要Jpa的配置扫描
 */
@EntityScan(basePackageClasses = {TestEquipBox.class})
@EnableJpaRepositories(basePackageClasses = {TestEquipBox.class})
/**
 * @Import 注解导入一些必须的配置类 看项目需要
 */
//@Import(SpringContextHolder.class)
/**
 * 回滚 TODO 得对它进行测试 好像只回滚了最后一次提交的东西?!
 */
@Rollback(value = false)
@Slf4j
public class TestEquipBox {
    @Autowired
    private EquipRepo equipRepo;

    @Autowired
    private EquipBoxRepo equipBoxRepo;

    /**
     * 判断是否导入成功
     */
    @Test
    void assertIsNull() {
        assertNotNull(equipRepo);
        assertNotNull(equipBoxRepo);
    }

    @Test
    void initData() {
        for (int i = 0; i < 10; i++) {
            equipRepo.save(new Equip());
        }
    }

    @Test
    void bindEquipBox() {
        EquipBox equipBox = new EquipBox();
        equipBox.setEquipBoxRfid(generateRfid());
        List<Equip> all = equipRepo.findAll();
        equipBox.addEquips(all);
        equipBoxRepo.save(equipBox);
    }

    /**
     * 删除装备检查中间级联的表是否会删除
     */
    @Test
    void delEquip() {
        List<Equip> equips = equipRepo.findAll().stream()
                .limit(2)
                .collect(Collectors.toList());
        equips.forEach(it -> log.info(it.getId()));
        equipRepo.deleteAll(equips);
    }

    /**
     * 删除箱的时候会把所有的装备 删除...
     */
    @Test
    void delBox() {
        EquipBox equipBox = equipBoxRepo.findAll().stream().findFirst().get();
        equipBoxRepo.delete(equipBox);
    }

    /**
     *
     */
    @Test
    void changeEquipState() {
        Equip equip = equipRepo.findAll().stream().findFirst().get();
        log.info(equip.getId());
        equip.setState(true);
//        equip.publishSelf();
        equipRepo.save(equip);
    }

    @EventListener
    public void EquipState(Equip equip) {

    }


    private String generateRfid() {
        return String.format("%x", (int) (Math.random() * 999999));
    }


}
