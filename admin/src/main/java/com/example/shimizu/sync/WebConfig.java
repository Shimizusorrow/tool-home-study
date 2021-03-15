package com.example.shimizu.sync;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-10 10:12
 */
@ConfigurationProperties(prefix = WebConfig.prefix)
@Getter
@Setter
@NoArgsConstructor
public class WebConfig {
    public static final String prefix = "organ";

    private List<WebInfo> houses;

    @Data
    public static class WebInfo {
        private String id;
        private String name;
        private String appId;
        private String secret;
        private String address;
    }
}
