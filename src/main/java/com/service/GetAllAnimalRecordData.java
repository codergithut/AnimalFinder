package com.service;

import com.model.AnimalRecordData;

import java.io.FileReader;
import java.util.List;

/**
 * Created by tianjian on 2020/2/29.
 */
public interface GetAllAnimalRecordData {
    /**
     * 根据文件获取动物记录数据
     * @param fileReader
     * @return
     */
    List<AnimalRecordData> getAllAnimalRecordData(FileReader fileReader);
}
