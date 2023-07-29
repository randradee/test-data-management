package com.randradee.test.data.management.domain.testcase;

import com.randradee.test.data.management.domain.attribute.AttributeResponseDTO;

import java.util.List;

public record TestCaseWithAttributesResponseDTO(
        Long suiteId,
        Long testCaseId,
        String name,
        List<AttributeResponseDTO> attributeList
) {
}
