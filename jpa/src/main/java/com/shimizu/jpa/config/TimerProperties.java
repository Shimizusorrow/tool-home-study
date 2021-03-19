package com.shimizu.jpa.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-17 09:49
 */
@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = TimerProperties.PREFIX)
public class TimerProperties {
    public final static String PREFIX = "timer.case";

    private Duration f1Time = Duration.ofDays(3);

    private Duration f2Time = Duration.ofHours(1);

    public long getF1TimeSeconds() {
        return this.f1Time.getSeconds();
    }
}
