package com.shimizu.jpa.domain.complex;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Shimizu
 * @description 教室
 * @date 2020-12-09 16:58
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassRoom extends BaseEntity {
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<Chair> chairs = new HashSet<>();
}
