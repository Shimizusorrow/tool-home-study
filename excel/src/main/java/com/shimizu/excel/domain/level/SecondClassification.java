package com.shimizu.excel.domain.level;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 三级分类
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 10:44
 */
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class SecondClassification {
    private String secondName;
    private String secondNumber;

    public SecondClassification(String secondName, String secondNumber) {
        this.secondName = secondName;
        this.secondNumber = secondNumber;
    }
}
