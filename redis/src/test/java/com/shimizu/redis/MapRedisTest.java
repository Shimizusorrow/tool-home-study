package com.shimizu.redis;

import com.alibaba.fastjson.JSON;
import com.shimizu.redis.domain.Dcs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.redis.DataRedisTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sun.reflect.generics.tree.VoidDescriptor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created Date : 2020/09/28
 *
 * @author zzk
 */
@ExtendWith(SpringExtension.class)
@DataRedisTest
public class MapRedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ValueOperations<String, String> valueOperations;

    @BeforeEach
    void setUp() {
//        valueOperations = redisTemplate.opsForValue();
//        valueOperations.setIfAbsent("age", 0 + "");
    }

    @AfterEach
    void afterUp() {
//        redisTemplate.delete("age");
    }


    @Test
    void nutNull() {
        assertThat(redisTemplate);
    }

    @Test
    void incrValue() {
//        valueOperations.increment("age");
//        String age = valueOperations.get("age");
//        assertThat(age).isEqualTo("1");
    }

    private final String KEY = "user_key";

    @Test
    void map() {

//        ArrayList<Dcs> dcs = new ArrayList<>(Arrays.asList(
//                new Dcs("1", "张三", "男"),
//                new Dcs("2", "李四", "女")
//        ));
//        Map<String, Dcs> userMap = dcs.stream().collect(Collectors.toMap(Dcs::getId, it -> it));

//        redisTemplate.opsForValue().set(KEY, JSON.toJSONString(userMap));
//        redisTemplate.opsForValue().set(KEY, JSON.toJSONString(dcs));
//        redisTemplate.opsForHash().put(KEY, "1123", "123");
        Dcs dcs1 = new Dcs("1", "张三", "男");
        Dcs dcs2 = new Dcs("2", "李四", "女");
        redisTemplate.opsForHash().put(KEY, dcs1.getId(), JSON.toJSONString(dcs1));
        redisTemplate.opsForHash().put(KEY, dcs2.getId(), JSON.toJSONString(dcs2));


//        redisTemplate.opsForHash().get();
    }

    @Test
    void mapOut() {
//        String s = redisTemplate.opsForValue().get(KEY);
//        List dcs = JSON.parseObject(s, List.class);
//        List<Dcs> ss = (List<Dcs>) dcs.stream().map(it -> JSON.parseObject(JSON.toJSONString(it), Dcs.class)).collect(Collectors.toList());
//        ss.forEach(it -> System.out.println(it.toString()));
        Dcs dcs = JSON.parseObject((String) redisTemplate.opsForHash().get(KEY, "1"), Dcs.class);
//        Dcs dcs = (Dcs) redisTemplate.opsForHash().get(KEY, "1");
        System.out.println(dcs.toString());
    }

    @Test
    void mapRemove() {
//        ArrayList<String> strings = new ArrayList<>(Arrays.asList("0", "1"));
//        redisTemplate.opsForHash().delete(KEY, strings.toArray());
        redisTemplate.opsForHash().delete(KEY, new String[]{"0", "1"});
    }
    public static final Calendar CALENDAR =Calendar.getInstance();
    @Test
    void test(){
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonthValue());
//        String year="2021";
//        String year1="2021";
//        String month="2";
//        String month1="1";
//
//        CALENDAR.set(Integer.valueOf(year), Integer.valueOf(month), 0); //输入类型为int类型
//        System.out.println(CALENDAR.get(Calendar.DAY_OF_MONTH));
//        CALENDAR.set(Integer.valueOf(year1),Integer.valueOf(month1),0);
//        System.out.println(CALENDAR.get(Calendar.DAY_OF_MONTH));
    }


    public static final String THE_KEY="2021:3:3";
    @Test
    void test1(){
        redisTemplate.opsForList().rightPush(THE_KEY,"123");
        redisTemplate.opsForList().leftPush(THE_KEY,"321");
        redisTemplate.expire(THE_KEY,60, TimeUnit.SECONDS);
    }
    @Test
    void test3(){
        redisTemplate.opsForList().leftPush(THE_KEY,"3212");
    }

    @Test
    void test2(){
        List<String> range = redisTemplate.opsForList().range(THE_KEY, 0, -1);
        System.out.println(range.size());
        range.forEach(System.out::println);
    }

}
