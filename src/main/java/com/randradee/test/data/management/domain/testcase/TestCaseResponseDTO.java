package com.randradee.test.data.management.domain.testcase;

import com.randradee.test.data.management.domain.attribute.AttributeResponseDTO;

import java.util.List;

public record TestCaseResponseDTO(
        Long id,
        String name,
        Long suiteId
) {
}
