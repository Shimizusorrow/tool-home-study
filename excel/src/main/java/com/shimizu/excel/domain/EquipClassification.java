package com.shimizu.excel.domain;


import com.shimizu.excel.domain.level.FirstClassification;
import com.shimizu.excel.domain.level.FourthClassification;
import com.shimizu.excel.domain.level.SecondClassification;
import com.shimizu.excel.domain.level.ThirdClassification;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 装备分类层级
 *
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/21 10:38
 */
@Entity
@Getter
@NoArgsConstructor
public class EquipClassification {
    @Id
    private String id;

    private FirstClassification firstClassification;

    private SecondClassification secondClassification;

    private ThirdClassification thirdClassification;

    private FourthClassification fourthClassification;


    public EquipClassification(String id, FirstClassification firstClassification, SecondClassification secondClassification, ThirdClassification thirdClassification, FourthClassification fourthClassification) {
        this.id = id;
        this.firstClassification = firstClassification;
        this.secondClassification = secondClassification;
        this.thirdClassification = thirdClassification;
        this.fourthClassification = fourthClassification;
//        this.fullNumber = firstClassification.getFirstNumber()
//                + secondClassification.getSecondNumber()
//                + thirdClassification.getThirdNumber()
//                + fourthClassification.getFourthNumber();
    }
}
