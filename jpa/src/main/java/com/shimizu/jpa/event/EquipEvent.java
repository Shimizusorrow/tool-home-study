package com.shimizu.jpa.event;

import com.shimizu.jpa.domain.Equip;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.webresources.TomcatJarInputStream;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class EquipEvent extends ApplicationEvent {
    private Equip equip;

    public EquipEvent(Equip equip) {
        super(equip);
        this.equip = equip;
    }
}
