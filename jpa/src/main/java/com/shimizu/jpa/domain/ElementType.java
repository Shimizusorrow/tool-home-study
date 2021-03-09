package com.shimizu.jpa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-09 13:15
 */
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class ElementType {
    public static final String ENTITY_ID = "parentId";
    public static final String INDEX = "rfId";
    public static final String NAME = "ElementType";
    private String rfId;

    public ElementType(String rfId) {
        this.rfId = rfId;
    }
}
