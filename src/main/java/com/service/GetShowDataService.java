package com.service;

import com.model.AnimalData;
import com.model.ValidationResult;

import java.util.List;

/**
 * Created by tianjian on 2020/2/29.
 */
public interface GetShowDataService {
    /**
     * 获取展示数据
     * @param animalDatas 动物行动数据
     * @param validationResults 异常数据
     * @param checkIndex 需要检查的数据编码
     */
    void getShowDataService(List<AnimalData> animalDatas, List<ValidationResult> validationResults, String checkIndex);
}
