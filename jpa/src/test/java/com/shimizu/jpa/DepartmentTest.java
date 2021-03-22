package com.shimizu.jpa;

import com.shimizu.jpa.config.DepartmentConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-11 08:21
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("junit")
@Disabled
public class DepartmentTest {
    @Autowired
    private DepartmentConfig departmentConfig;

    @Test
    void test() {
        System.out.println(departmentConfig.getName());
        List<DepartmentConfig.DepartmentVO> department = departmentConfig.getDepartment();
        department.forEach(it -> System.out.println(it.toString()));

        System.out.println(departmentConfig.list.toString());
    }
}
