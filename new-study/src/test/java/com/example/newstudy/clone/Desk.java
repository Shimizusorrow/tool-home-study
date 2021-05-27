package com.example.newstudy.clone;

import java.io.Serializable;

/**
 * 桌子
 *
 * @author Shimizu
 * @date 2021-05-27 15:02
 */
public class Desk implements Serializable {
    private static final long serialVersionUID = -6683700984071462082L;
    private String number;


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Desk{" +
                "number='" + number + '\'' +
                '}';
    }
}
