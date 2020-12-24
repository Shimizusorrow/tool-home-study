package com.shimizu.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.management.timer.Timer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.shimizu.hutool.BoxRfidParseUtils.parseEquipCount;


/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/24 8:54
 */
@ExtendWith(SpringExtension.class)
public class HuToolTest {
    @Test
    void test1() {
        List<String> list = new ArrayList<>(500);
        for (int i = 0; i < 500; i++) {
            list.add(System.currentTimeMillis() +"***"+ String.valueOf((int) (Math.random() * 999)));
        }
        list.forEach(it-> System.out.println(it));
    }

    @Test
    void test() {
        for (int i = 0; i < 100; i++)
//            System.out.println(String.valueOf((int) (Math.random() * 8) + 1));
            System.out.println(randSurface());
//        retry();
    }

    private SurfaceEnum randSurface() {
        if (((int) (Math.random() * 10) + 1) % 2 == 0) {
            return SurfaceEnum.A;
        } else {
            return SurfaceEnum.B;
        }
    }

    enum SurfaceEnum {
        A, B
    }

    private void retry() {
        retry:
        for (int i = 0; i < 10; i++) {

            for (int j = i; j < 10; j++) {
                if (j > 5) {
                    continue retry;
                }
                if (j == 3) {
                    break retry;
                }
                System.out.println(j);
            }
//            if (i==6){
//                break retry;
//            }

        }

    }

    @Test
    void copy() {
//        InputStream inputStream=new InputStream(new Fi);
//        IoUtil.copy();
    }

    @Test
    void testConvert() {
        String a = "010101010101010101";
        String s = Long.toHexString(Long.parseLong(a));
        System.out.println("---------------");
        System.out.println(s);
        String s1 = Convert.toHex(a, Charset.defaultCharset());
    }

    @Test
    void otherTest() {
        List<String> strings = Arrays.asList("1", "2");
        ArrayList<Object> objects = new ArrayList<>();
        System.out.println(strings.get(strings.size() - 1));
        System.out.println(objects.get(strings.size() - 1));
    }

    @Test
    void _2020_10_7() {
        HouseCategoryEnum[] values = HouseCategoryEnum.values();
        List<HouseCategoryEnum> houseCategoryEnums = Arrays.asList(values);
        List<String> strings = houseCategoryEnums.stream().map(Enum::name).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }

    @Test
    void _2020_10_9() {
        Long value = Long.valueOf("5301");
        String s = Long.toHexString(value);
        System.out.println(s);
        /**
         *
         */
        Long of = Long.valueOf("6401");
        String s1 = Long.toHexString(of);
        System.out.println(String.format("%x", of));

    }

    @Test
    void _2020_10_10() {
        System.out.println();
        System.out.println(Timer.ONE_DAY * 365 * 8 + ((int) (Math.random() * 100000)));
        System.out.println(220752072946L / (Timer.ONE_DAY * 365));
        System.out.println(252288058988L / (Timer.ONE_DAY * 365));

        System.out.println(shelfLife2Hex(220752072946L));
        System.out.println(shelfLife2Hex(252288058988L));

        System.out.println(String.valueOf(0));

        System.out.println(productDate2Hex(1602315857000L));
        System.out.println((1602315857000L - MIN_PRODUCT_TIME) / Timer.ONE_DAY);

        String x = "1234567891234567890012345";
        System.out.println(x.substring(20, 24));
    }

    @Test
    void _2020_10_13() {
        String equipRfidValue = "33030014103011001D9B0001";
        System.out.println(EquipRfidParseUtils.parseDistrictNumber(equipRfidValue));
        System.out.println(EquipRfidParseUtils.parseEquipArgNumber(equipRfidValue));
        System.out.println(EquipRfidParseUtils.parseEquipClassificationNumber(equipRfidValue));
        System.out.println(EquipRfidParseUtils.parseWriterNumber(equipRfidValue));
        System.out.println(EquipRfidParseUtils.parseShelfLifeNumber(equipRfidValue));
        System.out.println(EquipRfidParseUtils.parseProductDateNumber(equipRfidValue));
        System.out.println(EquipRfidParseUtils.parseEquipSerialNumber(equipRfidValue));

        StringBuilder stringBuilder = new StringBuilder();
        String string = stringBuilder
                //预留编号 默认为F
                .append("F")
                .append(EquipRfidParseUtils.parseDistrictNumber(equipRfidValue))
                .append(EquipRfidParseUtils.parseEquipArgNumber(equipRfidValue))
                .append(EquipRfidParseUtils.parseEquipClassificationNumber(equipRfidValue))
                //写入者编号默认为0
                .append("0")
                .append("0")
                .append(addOneEquipSerialNumber(EquipRfidParseUtils.parseEquipSerialNumber(equipRfidValue)))
                .append(EquipRfidParseUtils.parseShelfLifeNumber(equipRfidValue))
                .append(EquipRfidParseUtils.parseProductDateNumber(equipRfidValue))
                .toString();

        System.out.println(string);

        long l = Long.parseLong("000a", 16);
        System.out.println(String.format("%04x", l + 1));
        System.out.println(l);
    }

    @Test
    void _2020_10_21() {
        String boxrfid = "33030014101002001d9b00030061ffff";

//        System.out.println(boxrfid.length());
        System.out.println(BoxRfidParseUtils.parseEquipSerialNumber(boxrfid));
        System.out.println(BoxRfidParseUtils.parseEquipRfidNoSerial(boxrfid));
        System.out.println(parseEquipCount(boxrfid));

        String a = "a";
        System.out.println(Long.parseLong(a, 16));

        HashSet<String> set = BoxRfidParseUtils.parseBoxRfid2EquipRfidSet(boxrfid);
        set.forEach(System.out::println);

    }

    @Test
    void _2020_10_22() {
        String a = "9";
        String s = String.format("%02d", Long.parseLong(a));
        System.out.println(s);
        System.out.println(String.format("%04x", (int) (Math.random() * 9999)));

    }


    private String addOneEquipSerialNumber(String equipSerialNumber) {
        return String.format("%04x", Long.parseLong(equipSerialNumber) + 1);
    }

    private String shelfLife2Hex(Long shelfLife) {
        int year = (int) (shelfLife / (Timer.ONE_DAY * 365));
        if (year == 10) {
            return "a";
        }
        if (year == 11) {
            return "b";
        }
        if (year == 12) {
            return "c";
        }
        if (year >= 15 && year < 20) {
            return "c";
        }
        if (year >= 20 && year < 25) {
            return "d";
        }
        if (year >= 25 && year < 99) {
            return "e";
        }
        if (year >= 99) {
            return "f";
        }
        return String.valueOf(year);
    }

    @Test
    void _2020_10_26() {
        List<String> strings = Arrays.asList("1", "2", "3");
        List<String> collect = strings.stream().filter(it -> !it.equals("1")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    void _2020_10_30() {
        System.out.println(feiBoNaQi(0, 1, 10));
    }

    @Test
    void _2020_11_2() {
        Stream.iterate(0, x -> x + 1).limit(10).forEach(
                it -> {
                    System.out.println(getNoRepeatRfid());
                }
        );
    }

    /**
     * 生成不重复的Rfid
     *
     * @return
     */
    private String getNoRepeatRfid() {
        String temp = generateRfid();
        while (isIncludeRfid(temp)) {
            temp = generateRfid();
        }
        return temp;
    }

    private static final Set<String> RFID_SET = new HashSet<>();

    /**
     * 判断是否存在了rfid
     *
     * @param rfid
     * @return
     */
    private boolean isIncludeRfid(String rfid) {
        if (RFID_SET.contains(rfid)) {
            return true;
        } else {
            RFID_SET.add(rfid);
            return false;
        }
    }

    /**
     * 生成8位 16进制的Rfid
     *
     * @return
     * @date 2020年11月5日15:59:55 补充转大写
     */
    private String generateRfid() {
        return (String.format("%06x", (int) (Math.random() * 999999)) + String.format("%02x", (int) (Math.random() * 99))).toUpperCase();
    }

    private int feiBoNaQi(int cur, int next, int n) {
        if (n == 0) {
            return cur;
        } else {
            System.out.println(next);
            return feiBoNaQi(next, cur + next, n - 1);
        }
    }

    private final Long MIN_PRODUCT_TIME = 946656000000L;

    private String productDate2Hex(Long productDate) {
        return String.format("%04x", (productDate - MIN_PRODUCT_TIME) / Timer.ONE_DAY);
    }
}
