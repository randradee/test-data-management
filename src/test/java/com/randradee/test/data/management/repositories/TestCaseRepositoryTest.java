package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.testcase.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashMap;
import java.util.Map;


@DataJpaTest
@ActiveProfiles("test")
class TestCaseRepositoryTest {
    @Autowired
    private TestCaseRepository testCaseRepository;

    @Test
    void SaveTestCaseWithAttribute(){
        // Given
        TestCase testCase = new TestCase(1L, "test");
        Map<String, String> attribute = new HashMap<>();
        attribute.put("testAtt1", "testKey1");
        testCase.setVal(attribute);
        testCaseRepository.save(testCase);

        // When test case exists
        TestCase found = testCaseRepository.findById(1L).get();

        // Then
        Assertions.assertEquals("testKey1", found.getVal().get("testAtt1"));
    }

}