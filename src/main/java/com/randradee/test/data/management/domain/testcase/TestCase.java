package com.randradee.test.data.management.domain.testcase;

import com.randradee.test.data.management.domain.suite.TestSuite;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_TEST_CASE")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public TestCase(TestCaseRequestDTO dto, TestSuite suite){
        this.name = dto.name();
        this.testSuite = suite;
    }

    @ManyToOne
    private TestSuite testSuite;
}
