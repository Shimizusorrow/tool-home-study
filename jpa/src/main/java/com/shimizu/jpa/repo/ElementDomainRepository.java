package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.ElementDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Shimizu
 * @description
 * @date 2021-03-09 10:34
 */
public interface ElementDomainRepository extends JpaRepository<ElementDomain, String> {
    ElementDomain findByName(String name);

    @Query(nativeQuery = true,
            value = "select * from element_domain ed " +
                    "left join element_type et on ed.id=et.parent_id " +
                    "where et.rf_id in (:search)")
    List<ElementDomain> findByList(String search);
}
