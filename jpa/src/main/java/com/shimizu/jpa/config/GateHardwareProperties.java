package com.shimizu.jpa.config;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Shimizu
 * @description 门感设备配置
 * @date 2021-03-26 10:39
 */
@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = GateHardwareProperties.PREFIX)
public class GateHardwareProperties {
    public static final String PREFIX = "gate-hardware";

    private OutHouse outHouse = new OutHouse();

    /**
     * 出入库配置
     */
    @Getter
    @Setter
    @NoArgsConstructor
    public static class OutHouse {
        /**
         * 默认为false 关闭领取中的装备 可以出库
         */
        private boolean switches = false;
    }
}
