package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Equip extends BaseEntity {
    private boolean state = false;
}
