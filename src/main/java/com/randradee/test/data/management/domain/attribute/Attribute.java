package com.randradee.test.data.management.domain.attribute;

import com.randradee.test.data.management.domain.testcase.TestCase;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TB_ATTRIBUTE")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String attribute;
    private String val;
    @ManyToOne
    private TestCase testCase;

    public Attribute(AttributeRequestDTO attributeRequestDTO) {
        this.attribute = attributeRequestDTO.attribute();
        this.val = attributeRequestDTO.value();
    }
}
