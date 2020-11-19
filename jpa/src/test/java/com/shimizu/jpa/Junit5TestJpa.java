package com.shimizu.jpa;

import com.shimizu.jpa.domain.Student;
import com.shimizu.jpa.domain.StudentItems;
import com.shimizu.jpa.domain.Teacher;
import com.shimizu.jpa.repo.StuRepo;
import com.shimizu.jpa.repo.TeaRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.management.timer.Timer;
import java.util.Comparator;
import java.util.HashSet;

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
@ContextConfiguration(classes = {Junit5TestJpa.class})

/**
 * 这两个注解时为了将实体Domain 扫描到还要Jpa的配置扫描
 */
@EntityScan(basePackageClasses = {Junit5TestJpa.class})
@EnableJpaRepositories(basePackageClasses = {Junit5TestJpa.class})
/**
 * @Import 注解导入一些必须的配置类 看项目需要
 */
//@Import(SpringContextHolder.class)
/**
 * 回滚 TODO 得对它进行测试 好像只回滚了最后一次提交的东西?!
 */
@Rollback(value = false)
public class Junit5TestJpa {
    @Autowired
    private StuRepo stuRepo;
    @Autowired
    private TeaRepo teaRepo;

    /**
     * 判断是否导入成功
     */
    @Test
    void assertIsNull() {
        assertNotNull(stuRepo);
        assertNotNull(teaRepo);
    }

    @Test
    void initStudent() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            stuRepo.save(new Student("张" + i, "男"));
//            Thread.sleep(Timer.ONE_SECOND * 2);
        }
    }

    @Test
    void initTea() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            teaRepo.save(new Teacher("王" + i, "女"));
//            Thread.sleep(Timer.ONE_SECOND * 3);
        }
    }

    @Test
    void teaAdd() {
        Student student = stuRepo.findByName("张0");
        Teacher teacher = teaRepo.findByName("王1");
        Teacher teacher1 = teaRepo.findByName("王0");

//        teacher.setStudents(new HashSet<StudentItems>() {{
//            add(new StudentItems(teacher.getId(), student));
//        }});
//        teacher.setStudents(new HashSet<StudentItems>() {{
//            add(new StudentItems(teacher1.getId(), student));
//        }});

        teaRepo.save(teacher);
        teaRepo.save(teacher1);
    }

    @Test
    void testAll() {
        for (int i = 0; i < 5; i++) {
            stuRepo.save(new Student("张" + i, "男"));
//            Thread.sleep(Timer.ONE_SECOND * 2);
        }
        for (int i = 0; i < 2; i++) {
            teaRepo.save(new Teacher("王" + i, "女"));
//            Thread.sleep(Timer.ONE_SECOND * 3);
        }
        Student student = stuRepo.findByName("张0");
        Teacher teacher = teaRepo.findByName("王1");
        Teacher teacher1 = teaRepo.findByName("王0");

        teacher.setStudents(new HashSet<StudentItems>() {{
            add(new StudentItems(teacher, student));
        }});

        teacher1.setStudents(new HashSet<StudentItems>() {{
            add(new StudentItems(teacher1, student));
        }});

        teaRepo.save(teacher);
        teaRepo.save(teacher1);
    }

    @Test
    void del() {
        stuRepo.delete(stuRepo.findByName("张0"));
    }
    @Test
    void del2(){
        teaRepo.delete(teaRepo.findByName("王1"));
    }

    @Test
    void testRollBack() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            stuRepo.save(new Student("张" + i, "男"));
            Thread.sleep(Timer.ONE_SECOND * 3);
            teaRepo.save(new Teacher("王" + i, "女"));
            Thread.sleep(Timer.ONE_SECOND * 2);
        }
    }

    @Test
    void findStu() {
        stuRepo.findAll().stream()
                .sorted((o1, o2) -> (int) (o1.getCreateTime() - o2.getCreateTime()))
                .forEach(it -> {
                            System.out.println(it.getName());
                        }
                );
    }
}
