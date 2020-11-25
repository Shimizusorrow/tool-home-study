package com.shimizu.hutool;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@ActiveProfiles("value")
public class ChineseToPinYin {
    private final String name = "浙江华安安全有限公司";
    private final String equipArg = "警棍Rx-78";

    /**
     * 将中文转换为拼音
     */
    @Test
    void test() throws BadHanyuPinyinOutputFormatCombination {
      HanyuPinyinOutputFormat format=new HanyuPinyinOutputFormat();
      format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
//      format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
//      format.setVCharType(HanyuPinyinVCharType.WITH_V);
        String[] strings = PinyinHelper.toHanyuPinyinStringArray('华', format);
        System.out.println(String.join("",strings));

    }

    @Test
    void test_11_24() throws BadHanyuPinyinOutputFormatCombination {
        String s = PinYin4Utils.toUppercasePinYin(name);
//        System.out.println(String.format("%x",s));
        System.out.println(PinYin4Utils.toUppercasePinYin(name));
        System.out.println(PinYin4Utils.toLowercasePinYin(name));
        System.out.println(PinYin4Utils.toLowercasePinYin(equipArg));
    }
}
