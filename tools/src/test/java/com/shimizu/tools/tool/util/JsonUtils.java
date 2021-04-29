package com.shimizu.tools.tool.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsonUtils {
    /**
     * Logger for this class
     */
    private static final Logger log = LoggerFactory.getLogger(JsonUtils.class);

    private final static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 忽略未知的JSON字段 { "name":"张三" ,"age":14} to class Person {private String name;} 不会报错

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static ObjectMapper getInstance() {
        return objectMapper;
    }

    private JsonUtils() {
    }

    /**
     * 将对象转换为Json字符串
     *
     * @param obj
     * @return
     */
    public static String writeValueAsString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            log.warn("序列化失败,msg:{}, data: {}, clazz:{}", e.getMessage(), obj.toString(), obj.getClass().getSimpleName());
        }
        return null;
    }

    /**
     * 将json string反序列化成对象
     * <p>
     * 对象转换
     * String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
     * Car car = objectMapper.readValue(carJson, Car.class);
     * <p>
     * 数组转换
     * String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";
     * Car[] cars2 = objectMapper.readValue(jsonArray, Car[].class);
     *
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T readValue(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            log.warn("反序列化失败,msg:{}, data: {}, clazz:{}", e.getMessage(), json, valueType.getSimpleName());
        }
        return null;
    }

    /**
     * 将json 文件反序列化成对象
     * <p>
     * File file = new File("data/car.json");
     * Car car = objectMapper.readValue(file, Car.class);
     *
     * @param file
     * @param valueType
     * @return
     */
    public static <T> T readValue(File file, Class<T> valueType) {
        try {
            return objectMapper.readValue(file, valueType);
        } catch (IOException e) {
            log.warn("反序列化失败,msg:{}, data: {}, clazz:{}", e.getMessage(), file.getName(), valueType.getSimpleName());
        }
        return null;
    }

    /**
     * 将json 路径反序列化成对象
     * <p>
     * URL url = new URL("file:data/car.json");
     * Car car = objectMapper.readValue(url, Car.class);
     *
     * @param url
     * @param valueType
     * @return
     */
    public static <T> T readValue(URL url, Class<T> valueType) {
        try {
            return objectMapper.readValue(url, valueType);
        } catch (IOException e) {
            log.warn("反序列化失败,msg:{}, data: {}, clazz:{}", e.getMessage(), url.toString(), valueType.getSimpleName());
        }
        return null;
    }

    /**
     * 将json 二进制数组反序列化成对象
     * <p>
     * String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";
     * byte[] bytes = carJson.getBytes("UTF-8");
     * Car car = objectMapper.readValue(bytes, Car.class);
     *
     * @param bytes
     * @param valueType
     * @return
     */
    public static <T> T readValue(byte[] bytes, Class<T> valueType) {
        try {
            return objectMapper.readValue(bytes, valueType);
        } catch (IOException e) {
            log.warn("反序列化失败,msg:{}, data: {}, clazz:{}", e.getMessage(), bytes, valueType.getSimpleName());
        }
        return null;
    }


    /**
     * 将json array反序列化为对象
     * <p>
     * JsonUtils.readValue(json, new TypeReference<List<*>>() {});
     * JsonUtils.readValue(json, new TypeReference<Set<*>>() {});
     * JsonUtils.readValue(json, new TypeReference<Map<*,*>>() {});
     *
     * @param json
     * @param typeReference
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T readValue(String json, TypeReference<T> typeReference) {
        try {
            return (T) objectMapper.readValue(json, typeReference);
        } catch (IOException e) {
            log.warn("反序列化失败,msg:{}, data: {}, clazz:{}", e.getMessage(), json, typeReference.getClass().getSimpleName());
        }
        return null;
    }

    /**
     * 将json String 转换为JsonNode
     * <p>
     *
     * @param json
     * @return JsonNode
     */
    public static JsonNode readTree(String json) {
        try {
            return objectMapper.readTree(json);
        } catch (JsonProcessingException e) {
            log.warn("objectMapper转换为JsonNode失败,msg:{}, data: {}", e.getMessage(), json);
        }
        return null;
    }
}