package com.shimizu.excel.domain.level;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 二级分类
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 10:46
 */
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class FourthClassification {
    private String fourthName;
    private String fourthNumber;

    public FourthClassification(String fourthName, String fourthNumber) {
        this.fourthName = fourthName;
        this.fourthNumber = fourthNumber;
    }
}
