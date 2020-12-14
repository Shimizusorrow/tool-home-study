package com.shimizu.hutool;

import javafx.scene.input.DataFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.management.timer.Timer;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class TimeFormatTest {

    @Test
    void testLocalData() {
        System.out.println(LocalDate.now().toString() + " " + LocalTime.now());
    }


    @Test
    void _2020_11_3() {
        long day = 5184000000L;
        System.out.println(day / Timer.ONE_DAY);
        String a = "0";
        System.out.println(Integer.parseInt(a));

        System.out.println("======");
        System.out.println(3*Timer.ONE_DAY*365);
    }

    /**
     * 时间格式转换成时间戳
     */
    @Test
    void _2020_11_2() {
//        String data="2020-02-02";
        String date = "2020-11-02";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(time.getTime());
        System.out.println(millisecond2TimeFormat(System.currentTimeMillis()));
    }

    /**
     * 输出三天的时间戳
     */
    @Test
    void _2020_12_2() {
        System.out.println(30365080000L/Timer.ONE_DAY);
//        System.out.println(Timer.ONE_DAY * 3);
    }

    /**
     * 时间转换为时间戳
     *
     * @param date
     * @return N ms
     */
    private static Long timeFormat2Millisecond(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date time = null;
        try {
            time = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time.getTime();
    }

    /**
     * 时间戳转换格式
     *
     * @param millisecond
     * @return yyyy-mm-dd
     */
    private static String millisecond2TimeFormat(Long millisecond) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(millisecond);
        return simpleDateFormat.format(date);
    }

}
