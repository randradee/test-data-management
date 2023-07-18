package com.randradee.test.data.management.controllers;

import com.randradee.test.data.management.domain.suite.TestSuite;
import com.randradee.test.data.management.domain.suite.TestSuiteResponseDTO;
import com.randradee.test.data.management.domain.suite.TestSuiteWithCasesResponseDTO;
import com.randradee.test.data.management.domain.testcase.TestCaseRequestDTO;
import com.randradee.test.data.management.services.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/suites")
public class TestSuiteController {

    @Autowired
    TestSuiteService testSuiteService;

    @GetMapping
    public ResponseEntity<List<TestSuiteResponseDTO>> getSuites(){
        return ResponseEntity.ok().body(this.testSuiteService.getSuites());
    }

    @GetMapping(value = "/{id}/cases")
    public ResponseEntity<TestSuiteWithCasesResponseDTO> getSuiteWithCases(@PathVariable("id") Long suiteId)
            throws Exception{
        return ResponseEntity.ok().body(testSuiteService.getSuiteByIdWithTestCases(suiteId));
    }

    @PostMapping()
    public ResponseEntity<String> createTestCase(@RequestBody TestCaseRequestDTO data) throws Exception {
        testSuiteService.createTestCase(data);
        return ResponseEntity.ok().body("caso de teste criado");
    }
}
