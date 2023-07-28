package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.suite.TestSuite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestSuiteRepository extends JpaRepository<TestSuite, Long> {
}
