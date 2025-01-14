package com.passerby.userservice.service;

import com.passerby.userservice.model.Label;
import com.passerby.userservice.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LabelService {
    @Autowired
    private LabelRepository labelRepository;

    public Label getLabel(String labelKey) {
        return labelRepository.findByLabelKey(labelKey).orElse(null);
    }

    public Map<String, Label> getAllLabels() {
        List<Label> labelList = labelRepository.findAll();
        return labelList.stream().collect(Collectors.toMap(Label::getLabelKey, label -> label));
    }

    public boolean isValid(String labelKey) {
        Label label = labelRepository.findByLabelKey(labelKey).orElse(null);
        return label != null;
    }

}
