package com.shimizu.hutool;

import cn.hutool.core.convert.Convert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;


/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/24 8:54
 */
@ExtendWith(SpringExtension.class)
public class HuToolTest {

    @Test
    void test() {
        String a = Convert.toStr(1);
    }

    @Test
    void copy() {
//        InputStream inputStream=new InputStream(new Fi);
//        IoUtil.copy();
    }
}
