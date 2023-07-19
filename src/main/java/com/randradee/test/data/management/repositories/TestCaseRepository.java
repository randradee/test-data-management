package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.testcase.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.Set;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query(nativeQuery = true, value = "SELECT id, name, test_suite_id FROM TB_TEST_CASE WHERE test_suite_id=:suiteId")
    Set<TestCase> findCasesBySuiteId(Long suiteId);
    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM TB_TEST_CASE WHERE id=:testCaseId AND test_suite_id=:suiteId")
    void deleteByIdAndSuiteId(Long suiteId, Long testCaseId);

    @Query(nativeQuery = true, value = "SELECT * FROM TB_TEST_CASE WHERE id=:testCaseId AND test_suite_id=:suiteId")
    Optional<TestCase> findCaseByIdAndSuiteId(Long suiteId, Long testCaseId);
}
