package com.randradee.test.data.management.controllers;

import com.randradee.test.data.management.domain.suite.TestSuite;
import com.randradee.test.data.management.domain.suite.TestSuiteResponseDTO;
import com.randradee.test.data.management.domain.suite.TestSuiteWithCasesResponseDTO;
import com.randradee.test.data.management.domain.testcase.TestCaseAttributeRequestDTO;
import com.randradee.test.data.management.domain.testcase.TestCaseRequestDTO;
import com.randradee.test.data.management.domain.testcase.TestCaseResponseDTO;
import com.randradee.test.data.management.services.TestCaseService;
import com.randradee.test.data.management.services.TestSuiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/suites")
public class TestSuiteController {

    @Autowired
    TestSuiteService testSuiteService;

    @Autowired
    TestCaseService testCaseService;

    @GetMapping
    public ResponseEntity<List<TestSuiteResponseDTO>> getSuites() {
        return ResponseEntity.ok().body(this.testSuiteService.getSuites());
    }

    @GetMapping("/{suiteId}/cases")
    public ResponseEntity<TestSuiteWithCasesResponseDTO> getSuiteWithCases(@PathVariable("suiteId") Long suiteId)
            throws Exception {
        return ResponseEntity.ok().body(testSuiteService.getSuiteByIdWithTestCases(suiteId));
    }

    @GetMapping("/{suiteId}/cases/{testCaseId}")
    public ResponseEntity<TestCaseResponseDTO> getTestCaseById(@PathVariable("suiteId") Long suiteId,
                                                               @PathVariable("testCaseId") Long testCaseId
    ) throws Exception {
        return ResponseEntity.ok().body(testCaseService.getTestCaseById(suiteId, testCaseId));
    }

    @PostMapping()
    public ResponseEntity<String> createTestCase(@RequestBody TestCaseRequestDTO data) throws Exception {
        testCaseService.createTestCase(data);
        return ResponseEntity.status(HttpStatus.CREATED).body("caso de teste criado");
    }

    @DeleteMapping("/{suiteId}/cases/{testCaseId}")
    public ResponseEntity<String> deleteTestCase(@PathVariable("suiteId") Long suiteId,
                                                 @PathVariable("testCaseId") Long testCaseId
    ) throws Exception {
        testCaseService.deleteTestCase(suiteId, testCaseId);
        return ResponseEntity.ok().body("caso de teste apagado com sucesso");
    }

    @PostMapping("/{suiteId}/cases/{testCaseId}")
    public ResponseEntity<String> insertAttributeInTestCase(@PathVariable("suiteId") Long suiteId,
                                                            @PathVariable("testCaseId") Long testCaseId,
                                                            @RequestBody TestCaseAttributeRequestDTO data
    ) throws Exception {
        this.testCaseService.saveAttributeToTestCase(suiteId, testCaseId, data.attribute(), data.value());
        return ResponseEntity.status(HttpStatus.CREATED).body("Atributo inserido");
    }
}
