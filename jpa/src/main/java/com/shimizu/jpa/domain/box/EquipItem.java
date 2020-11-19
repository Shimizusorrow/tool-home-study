package com.shimizu.jpa.domain.box;

import com.shimizu.jpa.domain.Equip;
import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquipItem extends BaseEntity {
    public static final String FEIGN_KEY = "equip_box_id";

    @ManyToOne
    private EquipBox equipBox;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Equip equip;

    public EquipItem(EquipBox equipBox, Equip equip) {
        this.equipBox = equipBox;
        this.equip = equip;
    }
}
