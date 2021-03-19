package com.shimizu.jpa.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-17 11:12
 */
@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = TestProperties.PREFIX)
public class TestProperties {
    public final static String PREFIX = "timer.data";

    private Duration f4 = Duration.ofHours(1);
}
