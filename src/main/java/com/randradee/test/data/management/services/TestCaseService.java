package com.randradee.test.data.management.services;

import com.randradee.test.data.management.domain.suite.TestSuite;
import com.randradee.test.data.management.domain.testcase.TestCase;
import com.randradee.test.data.management.repositories.TestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestCaseService {

    @Autowired
    TestCaseService testCaseService;

    public List<TestSuite> getCases(){
        return this.testCaseService.getCases();
    }

}
