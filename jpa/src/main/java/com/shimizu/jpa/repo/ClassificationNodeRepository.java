package com.shimizu.jpa.repo;

import com.shimizu.jpa.domain.node.ClassificationNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Shimizu
 * @description
 * @date 2020-12-14 10:07
 */
public interface ClassificationNodeRepository extends JpaRepository<ClassificationNode, String> {

    Optional<ClassificationNode> findByNameAndCode(String name, String code);

    @Query(nativeQuery = true,
            value = "select * from classification_node cn where cn.level = :level")
    List<ClassificationNode> findByLevel(String level);
}
