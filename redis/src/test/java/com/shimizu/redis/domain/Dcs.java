package com.shimizu.redis.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 测试对象
 */
@Data
@NoArgsConstructor
public class Dcs {
    private String id;
    private String name;
    private String gender;

    public Dcs(String id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}