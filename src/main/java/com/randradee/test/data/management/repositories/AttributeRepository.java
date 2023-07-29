package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.attribute.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    Attribute findByAttribute(String attribute);

    @Modifying
    @Query(nativeQuery = true, value = "INSERT INTO TB_ATTRIBUTE (TEST_CASE_ID, ATTRIBUTE, VAL)" +
            "VALUES(:testCaseId, :attribute, :val)")
    void saveInTestCase(Long testCaseId, String attribute, String val);
}
