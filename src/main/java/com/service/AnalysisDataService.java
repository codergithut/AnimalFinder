package com.service;

import com.model.AnimalData;
import com.model.AnimalRecordData;
import com.model.ValidationResult;

import java.util.List;

/**
 * Created by tianjian on 2020/2/29.
 */
public interface AnalysisDataService {

    /**
     * 分析动物地点数据
     * @param animalRecordDatas
     */
    void analysisAnimalData(List<AnimalRecordData> animalRecordDatas);

    /**
     * 获取验证结果
     * @return
     */
    List<ValidationResult> getValidationResults();

    /**
     * 获取动物活动数据
     * @return
     */
    List<AnimalData> getAllData();
}
