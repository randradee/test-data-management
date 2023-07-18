package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.testcase.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM TB_TEST_CASE WHERE test_suite_id=:suiteId")
    Set<TestCase> findCasesBySuiteId(Long suiteId);
}
