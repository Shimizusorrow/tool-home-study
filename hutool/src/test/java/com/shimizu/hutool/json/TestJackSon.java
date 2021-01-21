package com.shimizu.hutool.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;


/**
 * 测试学习jackson
 *
 * @author Shimizu
 * @description
 * @date 2021-01-21 11:35
 */
@ExtendWith(SpringExtension.class)
public class TestJackSon {
    private final Logger log = LoggerFactory.getLogger(TestJackSon.class);

    /**
     * 使用JsonUtil 工具
     */
    @Test
    void test() {
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        Temp2 temp = null;
        String json = null;
        temp = JsonUtils.readValue(jsonString, Temp2.class);
        json = JsonUtils.writeValueAsString(temp);
        log.info(temp.toString());
        log.info("-----------");
        log.info(json);
    }

    @Test
    void test2() {
        List<Temp2> rs = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            rs.add(new Temp2() {{
                setName(String.valueOf(finalI));
            }});
        }
        String json = JsonUtils.writeValueAsString(rs);
        List<Temp2> temp2s = JsonUtils.readValue(json, new TypeReference<List<Temp2>>() {});
        temp2s.forEach(it -> log.info(it.name));
        log.info(json);
    }

    static class Temp2 {
        private String name;

        public Temp2() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Temp {
        private String name;
        private String age;

        @Override
        public String toString() {
            return "Temp{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Temp() {

        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
