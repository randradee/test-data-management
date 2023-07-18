package com.randradee.test.data.management.services;

import com.randradee.test.data.management.domain.suite.TestSuite;
import com.randradee.test.data.management.repositories.TestSuiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestSuiteService {

    @Autowired
    TestSuiteRepository testSuiteRepository;

    public List<TestSuite> getSuites(){
        return this.testSuiteRepository.findAll();
    }

}
