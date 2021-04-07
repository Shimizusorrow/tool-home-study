package com.shimizu.hutool.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.junit.jupiter.api.Assertions;
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
    private static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Test
    void testTreeNode() throws JsonProcessingException {
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";
        String jsonArray = "[{\"name\":\"hello\"}]";
        JsonNode jsonNode = mapper.readTree(jsonString);
        JsonNode readTree = mapper.readTree(jsonArray);
        System.out.println(readTree.isArray());
        System.out.println(readTree.get(0).get("name").asText());
        JsonNodeType nodeType = jsonNode.getNodeType();
        Class<JsonNodeType> aClass = nodeType.getDeclaringClass();
        System.out.println(jsonNode.get("0"));
        System.out.println(jsonNode.get(0));
        System.out.println(jsonNode.isObject());
        System.out.println(jsonNode.isArray());
        System.out.println(jsonNode.isBigDecimal());

    }

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
        List<Temp2> temp2s = JsonUtils.readValue(json, new TypeReference<List<Temp2>>() {
        });
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

    @Test
    void testEnum() throws JsonProcessingException {
        String A = "\"A\"";
//        String s = mapper.writeValueAsString(A);
        System.out.println(A);

        TestEnum value = mapper.readValue(A, TestEnum.class);
        Assertions.assertEquals(TestEnum.A, value);
    }

    public static enum TestEnum {
        A, B;

        @JsonCreator
        public static <T> TestEnum formate(T name) {
            if (name != null) {
                if (name instanceof String) {
                    String tp = (String) name;
                    System.out.println("name is String");
                    return TestEnum.valueOf(tp);
                }
            }
            return null;
        }
    }
}
