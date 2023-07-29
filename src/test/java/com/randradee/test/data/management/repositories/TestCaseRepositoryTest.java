package com.randradee.test.data.management.repositories;

import com.randradee.test.data.management.domain.attribute.Attribute;
import com.randradee.test.data.management.domain.testcase.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@DataJpaTest
@ActiveProfiles("test")
class TestCaseRepositoryTest {
    @Autowired
    private TestCaseRepository testCaseRepository;

}