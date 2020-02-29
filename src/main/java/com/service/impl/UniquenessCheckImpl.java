package com.service.impl;

import com.model.AnimalRecordData;
import com.model.ValidationResult;
import com.service.UniquenessCheck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjian on 2020/2/29.
 */
public class UniquenessCheckImpl implements UniquenessCheck {
    @Override
    public List<ValidationResult> uniquesssCheck(List<AnimalRecordData> animalRecordDatas) {
        List<ValidationResult> validationResults = new ArrayList<>();
        List<String> key = new ArrayList<>();
        animalRecordDatas.stream().forEach(e -> {
            if(key.contains(e.getRecordCode())) {
                validationResults.add(ValidationResult.failValidationResult(e.getRecordCode(), "uniquesss data"));
            }else {
                key.add(e.getRecordCode());
            }
        });
        return validationResults;
    }
}
