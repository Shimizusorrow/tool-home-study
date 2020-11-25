package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 学生Crud
 *
 * @author shimizu
 * @date 2020年11月17日11:50:03
 */
public interface StuRepo extends JpaRepository<Student, String> {

    Student findByName(String name);

    @Query(nativeQuery = true,
            value = "select * from student s " +
                    "where :schoolNumber is null or s.school_number like %:schoolNumber%")
    List<Student> findBySchoolNumber(String schoolNumber);
}
