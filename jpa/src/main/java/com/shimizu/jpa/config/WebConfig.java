package com.shimizu.jpa.config;

import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import javax.servlet.MultipartConfigElement;
import javax.xml.crypto.Data;
import java.io.File;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-15 11:08
 */
@Configuration
@EnableConfigurationProperties(MultipartProperties.class)
public class WebConfig {
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        //设置临时文件位置
        String dir = System.getProperty("user.dir");
        final String TEMP_LOCATION = dir + "\\temp\\";
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.of(500L, DataUnit.MEGABYTES)); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.of(500L,DataUnit.MEGABYTES));
        File file = new File(TEMP_LOCATION);
        if (!file.exists()) {
            file.mkdirs();
        }
        factory.setLocation(TEMP_LOCATION);
        return factory.createMultipartConfig();
    }
}
