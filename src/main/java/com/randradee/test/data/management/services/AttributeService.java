package com.randradee.test.data.management.services;

import com.randradee.test.data.management.domain.attribute.Attribute;
import com.randradee.test.data.management.domain.attribute.AttributeRequestDTO;
import com.randradee.test.data.management.domain.attribute.AttributeResponseDTO;
import com.randradee.test.data.management.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    AttributeRepository attributeRepository;

    @Transactional
    public void createAttributeInTestCase(Long testCaseId, AttributeRequestDTO attributeRequestDTO) {
        var attributeToSave = new Attribute(attributeRequestDTO);
        attributeRepository.saveInTestCase(testCaseId, attributeToSave.getAttribute(), attributeToSave.getVal());
    }

    @Transactional
    public List<AttributeResponseDTO> getAttributes() {
        var attribute = attributeRepository.findAll();
        return attribute.stream().map(x -> new AttributeResponseDTO(x.getAttribute(), x.getVal())).toList();
    }

    @Transactional
    public AttributeResponseDTO getAttributeByName(String attributeName) {
        var attribute = attributeRepository.findByAttribute(attributeName);
        return new AttributeResponseDTO(attribute.getAttribute(), attribute.getVal());
    }

    @Transactional
    public void deleteAttribute(String attributeName) {
        var attribute = attributeRepository.findByAttribute(attributeName);
        attributeRepository.delete(attribute);
    }


}
