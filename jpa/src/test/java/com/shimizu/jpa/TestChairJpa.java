package com.shimizu.jpa;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-10 15:11
 */

import com.shimizu.jpa.repo.ChairRepository;
import com.shimizu.jpa.repo.ClassRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
//@ContextConfiguration(classes = {TestCharJpa.class})

/**
 * 这两个注解时为了将实体Domain 扫描到还要Jpa的配置扫描
 */
@EntityScan(basePackageClasses = {TestChairJpa.class})
@EnableJpaRepositories(basePackageClasses = {TestChairJpa.class})
/**
 * @Import 注解导入一些必须的配置类 看项目需要
 */
//@Import(SpringContextHolder.class)
/**
 * 回滚 TODO 得对它进行测试 好像只回滚了最后一次提交的东西?!
 */
@Rollback(value = false)
@Slf4j
@Disabled
public class TestChairJpa {
    @Autowired
    private ChairRepository chairRepository;
    @Autowired
    private ClassRoomRepository classRoomRepository;

    @Test
    void notNull() {
        assertNotNull(chairRepository);
        assertNotNull(classRoomRepository);
    }
}
