package com.randradee.test.data.management.controllers;

import com.randradee.test.data.management.domain.suite.TestSuite;
import com.randradee.test.data.management.services.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cases")
public class TestCaseController {

    @Autowired
    TestCaseService testCaseService;

    @GetMapping
    public ResponseEntity<List<TestSuite>> getCases(){
        return ResponseEntity.ok().body(this.testCaseService.getCases());
    }

}
