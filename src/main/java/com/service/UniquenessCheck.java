package com.service;

import com.model.AnimalRecordData;
import com.model.ValidationResult;

import java.util.List;

/**
 * Created by tianjian on 2020/2/29.
 */
public interface UniquenessCheck {
    /**
     * 数据主见唯一性校验
     * @param animalRecordDatas
     * @return
     */
    List<ValidationResult> uniquesssCheck(List<AnimalRecordData> animalRecordDatas);
}
