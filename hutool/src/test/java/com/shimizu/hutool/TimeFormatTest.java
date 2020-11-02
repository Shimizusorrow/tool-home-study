package com.shimizu.hutool;

import javafx.scene.input.DataFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class TimeFormatTest {
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
