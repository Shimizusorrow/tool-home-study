package com.shimizu.excel.domain.level;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 四级分类
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 10:46
 */
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ThirdClassification {
    private String thirdName;
    private String thirdNumber;

    public ThirdClassification(String thirdName, String thirdNumber) {
        this.thirdName = thirdName;
        this.thirdNumber = thirdNumber;
    }
}
