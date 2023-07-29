package com.randradee.test.data.management.domain.attribute;

public record AttributeRequestDTO(
        String attribute,
        String value,
        Long testCaseId
) {
}
