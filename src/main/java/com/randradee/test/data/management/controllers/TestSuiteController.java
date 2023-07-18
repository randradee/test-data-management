package com.randradee.test.data.management.controllers;

import com.randradee.test.data.management.domain.suite.TestSuite;
import com.randradee.test.data.management.services.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/suites")
public class TestSuiteController {

    @Autowired
    TestSuiteService testSuiteService;

    @GetMapping
    public ResponseEntity<List<TestSuite>> getSuites(){
        return ResponseEntity.ok().body(this.testSuiteService.getSuites());
    }

}
