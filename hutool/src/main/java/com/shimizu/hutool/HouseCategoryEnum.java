package com.shimizu.hutool;

import lombok.Getter;

/**
 * @author Curtain
 * @date 2019-12-25 10:41
 */
@Getter
public enum HouseCategoryEnum {
    /**
     * 类别（单警、公共）
     */
    VEHICLE("车载装备"),
    SINGLE_POLICE("单警"),
    COMMON("公共"),
    EMERGENCY("应急");

    String desc;


    HouseCategoryEnum(String desc) {
        this.desc = desc;
    }
}
