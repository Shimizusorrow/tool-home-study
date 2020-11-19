package com.shimizu.jpa.domain;

import com.shimizu.jpa.domain.base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudentItems extends BaseEntity {
    public static final String FEIGN_KEY = "teacher_id";

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    public StudentItems(Teacher teacher, Student student) {
        this.teacher = teacher;
        this.student = student;
    }
}
