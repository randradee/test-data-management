package com.randradee.test.data.management.domain.suite;

import com.randradee.test.data.management.domain.testcase.TestCase;

import java.util.Set;

public record TestSuiteWithCasesResponseDTO(
        Long id,
        String name,
        Set<TestCase> testCases
) {
}
