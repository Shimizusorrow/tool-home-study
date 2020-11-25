package com.shimizu.hutool;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.stereotype.Component;

/**
 * PinYin4工具类
 *
 * @author shimizu
 * @date 2020年11月24日10:04:24
 */
@Component
public class PinYin4Utils {
    private static HanyuPinyinOutputFormat uppercaseFormat = null;
    private static HanyuPinyinOutputFormat lowercaseFormat = null;

    /**
     * outputFormat.setToneType(HanyuPinyinToneType);
     * <p>
     * 方法参数HanyuPinyinToneType有以下常量对象：
     * <p>
     * HanyuPinyinToneType.WITH_TONE_NUMBER 用数字表示声调，例如：liu2
     * <p>
     * HanyuPinyinToneType.WITHOUT_TONE 无声调表示，例如：liu
     * <p>
     * HanyuPinyinToneType.WITH_TONE_MARK 用声调符号表示，例如：liú
     * <p>
     * outputFormat.setVCharType(HanyuPinyinVCharType);
     * <p>
     * 方法参数HanyuPinyinVCharType有以下常量对象：
     * <p>
     * HanyuPinyinVCharType.WITH_U_AND_COLON 以U和一个冒号表示该拼音，例如：lu:
     * <p>
     * HanyuPinyinVCharType.WITH_V 以V表示该字符，例如：lv
     * <p>
     * HanyuPinyinVCharType.WITH_U_UNICODE 以ü表示
     * <p>
     * outputFormat.setCaseType(HanyuPinyinCaseType);
     * <p>
     * HanyuPinyinCaseType.LOWERCASE 转换后以全小写方式输出
     * <p>
     * HanyuPinyinCaseType.UPPERCASE 转换后以全大写方式输出
     */
    public PinYin4Utils() {
        uppercaseFormat = new HanyuPinyinOutputFormat();
        uppercaseFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        uppercaseFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        uppercaseFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);

        lowercaseFormat = new HanyuPinyinOutputFormat();
        lowercaseFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        lowercaseFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        lowercaseFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
    }

    /**
     * 将中文转换为拼音大写
     *
     * @param str
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toUppercasePinYin(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, uppercaseFormat);
    }

    /**
     * 将中文转换为拼音小写
     *
     * @param str
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    public static String toLowercasePinYin(String str) throws BadHanyuPinyinOutputFormatCombination {
        return toPinYin(str, lowercaseFormat);
    }


    /**
     * 将中文转换为拼音
     *
     * @param str
     * @return
     * @throws BadHanyuPinyinOutputFormatCombination
     */
    private static String toPinYin(String str, HanyuPinyinOutputFormat format) throws BadHanyuPinyinOutputFormatCombination {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (isChinese(chars[i])) {
                String[] strings = PinyinHelper.toHanyuPinyinStringArray(chars[i], format);
                // 防止出现重复
                stringBuilder.append(String.join("", strings[0]));
            } else {
                stringBuilder.append(chars[i]);
            }

        }
        return stringBuilder.toString();
    }

    /**
     * 判断该字符是否为中文
     *
     * @param ch
     * @return
     */
    private static boolean isChinese(char ch) {
        if (!(19968 <= ch && ch < 40869)) {
            return false;
        }
        return true;
    }
}
