package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shimizu
 * @description 测试  @ElementCollection
 * @date 2021-03-09 10:32
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ElementDomain extends BaseEntity {

    private String name;


    /**
     * 默认开启外键关联
     */
    @ElementCollection
    /**
     * 只会修改表名中的字段名称为 element_list 表明还是为element_domain_list
     * 如果不填写则 表中的字段名为 list
     */
//    /**
//     * 修改不掉绑定的element_domain_id 为parentId
//     * If the join is for an element collection, the foreign
//     * key is in a collection table.
//     * 但是可以去除外键关联
//     */
//    @JoinColumn(name = "parentId", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    /**
     * name 是直接修改表的名字...
     * joinColumns 联合使用可以修改CollectionTable表中的字段名称
     */
    @CollectionTable(name = ElementType.NAME,
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            indexes = @Index(columnList = ElementType.INDEX),
            joinColumns = @JoinColumn(name = ElementType.ENTITY_ID)
    )
    private List<ElementType> list = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "element_map",
            foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT),
            indexes = @Index(columnList = "map_key"),
            joinColumns = @JoinColumn(name = "parentId"))
    private Map<String, String> map = new HashMap<>();

    public ElementDomain(String name, List<ElementType> list) {
        this.name = name;
        this.list = list;
    }
}
