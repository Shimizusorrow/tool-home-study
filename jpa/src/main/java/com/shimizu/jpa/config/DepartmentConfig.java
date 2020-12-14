package com.shimizu.jpa.config;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Shimizu
 * @description 部门配置
 * @date 2020-12-10 16:54
 */

@Configuration
@ConfigurationProperties(prefix = "departments")
@Data
public class DepartmentConfig {
    public List<DepartmentVO> department;
    public String name;
    public List<String> list;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class DepartmentVO {
        private String name;
        private String number;

        @Override
        public String toString() {
            return "DepartmentVO{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    '}';
        }
    }
}


