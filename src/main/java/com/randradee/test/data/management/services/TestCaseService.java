package com.randradee.test.data.management.services;

import com.randradee.test.data.management.domain.attribute.AttributeRequestDTO;
import com.randradee.test.data.management.domain.attribute.AttributeResponseDTO;
import com.randradee.test.data.management.domain.testcase.TestCase;
import com.randradee.test.data.management.domain.testcase.TestCaseRequestDTO;
import com.randradee.test.data.management.domain.testcase.TestCaseWithAttributesResponseDTO;
import com.randradee.test.data.management.repositories.AttributeRepository;
import com.randradee.test.data.management.repositories.TestCaseRepository;
import com.randradee.test.data.management.repositories.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestCaseService {
    @Autowired
    TestSuiteRepository testSuiteRepository;
    @Autowired
    TestCaseRepository testCaseRepository;
    @Autowired
    AttributeRepository attributeRepository;

    @Transactional
    public void createTestCase(TestCaseRequestDTO requestData) throws Exception {
        var suite = testSuiteRepository.findById(requestData.testSuiteId());
        if (suite.isEmpty()) {
            throw new Exception();
        }
        var newTestCase = new TestCase(requestData, suite.get());
        testCaseRepository.save(newTestCase);
    }

    @Transactional
    public TestCaseWithAttributesResponseDTO getTestCaseWithAttributesById(Long suiteId, Long testCaseId)
            throws Exception {
        var testCase = testCaseRepository.findCaseByIdAndSuiteId(suiteId, testCaseId);
        if (testCase.isEmpty()) {
            throw new Exception();
        }
        var attributes = attributeRepository.findAll();

        return new TestCaseWithAttributesResponseDTO(
                testCase.get().getTestSuite().getId(),
                testCase.get().getId(),
                testCase.get().getName(),
                attributes
                        .stream()
                        .map(x -> new AttributeResponseDTO(x.getAttribute(), x.getVal()))
                        .toList()
        );
    }

    @Transactional
    public void deleteTestCase(Long suiteId, Long testCaseId) throws Exception {
        var testCase = testCaseRepository.findCaseByIdAndSuiteId(suiteId, testCaseId);
        if (testCase.isEmpty()) {
            throw new Exception();
        }
        testCaseRepository.deleteByIdAndSuiteId(suiteId, testCaseId);
    }

}
