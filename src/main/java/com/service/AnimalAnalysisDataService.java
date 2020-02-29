package com.service;

import com.model.AnimalData;
import com.model.AnimalRecordData;
import com.model.ValidationResult;
import com.service.impl.AnalysisDataServiceImpl;
import com.service.impl.GetAllAnimalRecordDataImpl;
import com.service.impl.GetShowDataServiceImpl;
import com.service.impl.UniquenessCheckImpl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tianjian on 2020/2/29.
 */
public class AnimalAnalysisDataService {
    public boolean getSnopShot(String fileName, String checkIndex) throws FileNotFoundException {
        UniquenessCheck uniquenessCheck = new UniquenessCheckImpl();
        AnalysisDataService analysisDataService = new AnalysisDataServiceImpl();
        List<ValidationResult> validationResults = new ArrayList<>();
        //读取文件
        FileReader fileReader = new FileReader(fileName);
        //数据转换为java对象
        GetAllAnimalRecordDataImpl getAllAnimalRecordData = new GetAllAnimalRecordDataImpl();
        List<AnimalRecordData> animalRecordDatas = getAllAnimalRecordData.getAllAnimalRecordData(fileReader);
        //检查有没有违反唯一校验的数据
        validationResults.addAll(uniquenessCheck.uniquesssCheck(animalRecordDatas));
        //按照时间排序数据
        List<AnimalRecordData> sortDatas = animalRecordDatas.stream().sorted(Comparator.comparing(AnimalRecordData::getHappyTime))
                .collect(Collectors.toList());
        //分析数据
        analysisDataService.analysisAnimalData(sortDatas);
        List<AnimalData> animalDatas = analysisDataService.getAllData();
        validationResults.addAll(analysisDataService.getValidationResults());
        //根据分析数据定制化展示数据
        GetShowDataService getShowDataService = new GetShowDataServiceImpl();
        getShowDataService.getShowDataService(animalDatas,validationResults,checkIndex);
        return validationResults.isEmpty();
    }
}
