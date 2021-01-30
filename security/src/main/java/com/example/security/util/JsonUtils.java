package com.example.security.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author shimizu
 */
public class JsonUtils {
    /**
     * Logger for this class
     */
    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

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
            logger.error("writeValueAsString(Object)", e); //$NON-NLS-1$
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
            logger.error("readValue(String, Class<T>)", e);
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
            logger.error("readValue(File, Class<T>)", e);
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
            logger.error("readValue(URL, Class<T>)", e);
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
            logger.error("readValue(URL, Class<T>)", e);
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
            logger.error("readValue(String, JsonTypeReference<T>)", e);
        }
        return null;
    }

}