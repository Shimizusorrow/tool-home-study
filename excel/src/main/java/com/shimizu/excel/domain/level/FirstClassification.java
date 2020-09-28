package com.shimizu.excel.domain.level;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * 一级分类
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 10:40
 */
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class FirstClassification {
    private String firstName;
    private String firstNumber;

    public FirstClassification(String firstName, String firstNumber) {
        this.firstName = firstName;
        this.firstNumber = firstNumber;
    }
}
