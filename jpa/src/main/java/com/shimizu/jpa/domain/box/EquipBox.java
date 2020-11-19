package com.shimizu.jpa.domain.box;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.base.BaseEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class EquipBox extends BaseEntity {
    @NotNull
    private String equipBoxRfid;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = EquipItem.FEIGN_KEY)
    private Set<EquipItem> equipItems = new HashSet<>();

    /**
     * 绑定装备
     *
     * @param equips
     * @return
     */
    public Set<EquipItem> addEquips(List<Equip> equips) {
        this.equipItems.addAll(equips.stream().map(
                it -> new EquipItem(this, it)
        ).collect(Collectors.toSet()));
        return this.equipItems;
    }
}
