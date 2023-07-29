package com.randradee.test.data.management.domain.testcase;

import com.randradee.test.data.management.domain.suite.TestSuite;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_TEST_CASE")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private TestSuite testSuite;

    public TestCase(TestCaseRequestDTO dto, TestSuite suite) {
        this.name = dto.name();
        this.testSuite = suite;
    }

    public TestCase(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
