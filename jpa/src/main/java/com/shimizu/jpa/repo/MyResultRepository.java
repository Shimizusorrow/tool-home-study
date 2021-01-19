package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.concurrent.MyCondition;
import com.shimizu.jpa.domain.concurrent.MyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-01-03 11:03
 */
public interface MyResultRepository extends JpaRepository<MyResult, String> {
    MyResult findByName(String name);

    @Modifying
    @Query(nativeQuery = true,
            value = "delete from my_result where id in " +
                    " (select mr.id from (select id from my_result where name in (:names)) as mr)")
    void deleteAllByNames(List<String> names);
}
