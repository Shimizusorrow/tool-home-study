package com.shimizu.jpa.domain.node;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

/**
 * @author Shimizu
 * @description 层级节点
 * @date 2020-12-14 09:42
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassificationNode extends BaseEntity {
    private static final String parentId = "pid";
    private String name;
    private String code;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = ClassificationNode.parentId, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Set<ClassificationNode> nodes = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private Level level;

    public ClassificationNode(String name, String code, Level level) {
        this.name = name;
        this.code = code;
        this.level = level;
    }

    public ClassificationNode(ClassificationNode node) {
        this.name = node.getName();
        this.code = node.getCode();
        this.level = node.getLevel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassificationNode that = (ClassificationNode) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
