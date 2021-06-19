package com.shimizu.tools.tool.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author Shimizu
 * @date 2021-06-02 11:38
 */
public class FileTest {
    @Test
    void test() {
        File file = new File("D:\\work_jpg\\3cc9d2648e044dd8aa59548842cd29a5.png");
        System.out.println(file.isAbsolute());
    }
}
