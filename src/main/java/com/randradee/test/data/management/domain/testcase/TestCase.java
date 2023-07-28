package com.randradee.test.data.management.domain.testcase;

import com.randradee.test.data.management.domain.suite.TestSuite;
import jakarta.persistence.*;
import lombok.*;

import java.util.Map;

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

    @ElementCollection
    @CollectionTable(
            name = "TB_TEST_CASE_ATTRIBUTE_MAPPING",
            joinColumns = {
                    @JoinColumn(
                            name = "testCaseId",
                            referencedColumnName = "id"
                    )
            }
    )
    @MapKeyColumn(name = "attribute")
    private Map<String, String> val;

    @ManyToOne
    private TestSuite testSuite;

    public TestCase(TestCaseRequestDTO dto, TestSuite suite){
        this.name = dto.name();
        this.testSuite = suite;
    }

    public TestCase(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
