package com.shimizu.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author shimizu
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Teacher extends BaseEntity {
    private String name;

    private String gender;
    //
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = StudentItems.FEIGN_KEY)
//    private Set<StudentItems> students = new HashSet<>();
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    public Teacher(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
}
