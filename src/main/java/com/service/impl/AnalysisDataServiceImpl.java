package com.service.impl;

import com.model.AnimalData;
import com.model.AnimalRecordData;
import com.model.ValidationResult;
import com.service.AnalysisDataService;

import java.util.*;

/**
 * Created by tianjian on 2020/2/29.
 */
public class AnalysisDataServiceImpl implements AnalysisDataService {

    /**
     * 验证数据
     */
    private List<ValidationResult> validationResults = new ArrayList<>();

    /**
     * 动物行动数据
     */
    private List<AnimalData> allData = new ArrayList<>();

    @Override
    public void analysisAnimalData(List<AnimalRecordData> animalRecordDatas) {
        Map<String,AnimalData> animalMap = new HashMap<>();
        animalRecordDatas.forEach(e -> {
            List<String> datas = e.getData();
            if(datas != null && datas.size() > 0) {
                datas.forEach(ee -> {
                    AnimalData preAnimalData = null;
                    String[] values = ee.split(" ");
                    AnimalData animalData = new AnimalData();
                    //获取数据编码
                    String animalCode = values[0];
                    //获取当前坐标的4个数据
                    Integer oneNum = Integer.valueOf(values[1]);
                    Integer twoNum = Integer.valueOf(values[2]);
                    Integer threeNum = Integer.valueOf(values[3]);
                    Integer fourNum = Integer.valueOf(values[4]);
                    animalData.setAnimalCode(animalCode);
                    //查找当前是否存在历史数据
                    if(animalMap.containsKey(animalCode)) {
                        preAnimalData = animalMap.get(animalCode);
                    }
                    animalData.setAnimalCode(values[0]);
                    animalData.setFindDate(e.getHappyTime());
                    //第一次出现需要判断是不是最后两位是否为0
                    if(preAnimalData == null && (threeNum != 0 || fourNum != 0)) {
                        validationResults.add(ValidationResult
                                .failValidationResult(e.getRecordCode(), "conflict found at " + e.getRecordCode()));
                        return;
                        //判断数据逻辑是否正确 上一次出现的地点和这次地点做比较
                    } else if(preAnimalData != null){
                        Integer[] prePoint = preAnimalData.getCurrentPoint();
                        if(prePoint[0] != oneNum || prePoint[1] != twoNum) {
                            validationResults.add(ValidationResult
                                    .failValidationResult(e.getRecordCode(), "conflict found at " + e.getRecordCode()));
                            return;
                        }
                    }
                    Integer[] currentPoints = new Integer[]{
                            oneNum + threeNum,
                            twoNum + fourNum};
                    animalData.setCurrentPoint(currentPoints);
                    animalMap.put(animalCode, animalData);
                    animalData.setRecordCodes(e.getRecordCode());
                    allData.add(animalData);
                });
            }
        });
    }


    public List<ValidationResult> getValidationResults() {
        return validationResults;
    }

    public List<AnimalData> getAllData() {
        return allData;
    }

    public void setValidationResults(List<ValidationResult> validationResults) {
        this.validationResults = validationResults;
    }

    public void setAllData(List<AnimalData> allData) {
        this.allData = allData;
    }
}
