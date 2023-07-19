package com.randradee.test.data.management.services;

import com.randradee.test.data.management.domain.suite.TestSuiteResponseDTO;
import com.randradee.test.data.management.domain.suite.TestSuiteWithCasesResponseDTO;
import com.randradee.test.data.management.domain.testcase.TestCase;
import com.randradee.test.data.management.domain.testcase.TestCaseRequestDTO;
import com.randradee.test.data.management.repositories.TestCaseRepository;
import com.randradee.test.data.management.repositories.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestSuiteService {

    @Autowired
    TestSuiteRepository testSuiteRepository;

    @Autowired
    TestCaseRepository testCaseRepository;

    @Transactional
    public List<TestSuiteResponseDTO> getSuites(){
        return testSuiteRepository.findAll()
                .stream().map(suite -> new TestSuiteResponseDTO(suite.getId(), suite.getName())).toList();
    }

    @Transactional
    public TestSuiteWithCasesResponseDTO getSuiteByIdWithTestCases(Long suiteId) throws Exception{
        var cases = testCaseRepository.findCasesBySuiteId(suiteId);
        var suite = testSuiteRepository.findById(suiteId);
        if (suite.isEmpty()){
            throw new Exception();
        }
        return new TestSuiteWithCasesResponseDTO(suite.get().getId(), suite.get().getName(), cases);
    }
}
