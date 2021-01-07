package com.example.mybatis.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles
class MybatisUtilTest {
    @Test
    void test() {
        Connection conn = MybatisUtil.getSqlSession().getConnection();
        System.out.println(conn != null ? "连接成功" : "连接失败");
    }

}