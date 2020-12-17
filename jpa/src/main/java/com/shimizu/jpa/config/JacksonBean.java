package com.shimizu.jpa.config;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-17 15:37
 */
@Configuration
public class JacksonBean {
    @Bean
    public Hibernate5Module bean() {
        Hibernate5Module module = new Hibernate5Module();
        //若 属性被延时加载，则只加载 ID
        module.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
        return module;
    }
}
