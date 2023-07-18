package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.testcase.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCaseRepository extends JpaRepository<TestCase, Long> {
}
