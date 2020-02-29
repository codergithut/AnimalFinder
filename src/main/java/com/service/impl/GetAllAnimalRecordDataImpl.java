package com.service.impl;

import com.model.AnimalRecordData;
import com.service.GetAllAnimalRecordData;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.util.CommonUtil.getCurrentTime;
import static com.util.CommonUtil.isData;

/**
 * Created by tianjian on 2020/2/29.
 */
public class GetAllAnimalRecordDataImpl implements GetAllAnimalRecordData {

    @Override
    public List<AnimalRecordData> getAllAnimalRecordData(FileReader fileReader) {

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line = null;

        List<AnimalRecordData> animalRecordDatas = new ArrayList<>();

        AnimalRecordData animalRecordData = null;

        try {
            while ((line = bufferedReader.readLine())!=null){
                if(line.length() == 36 && line.contains("-")) {
                    if(animalRecordData != null) {
                        animalRecordDatas.add(animalRecordData);
                    }
                    animalRecordData = new AnimalRecordData();
                    animalRecordData.setRecordCode(line);
                } else if(isData(line)) {
                    animalRecordData.setHappyTime(getCurrentTime(line));
                    animalRecordData.setTime(line);
                } else {
                    if(animalRecordData != null && StringUtils.isNotBlank(line)) {
                        line += " 0 0";
                        animalRecordData.addDatas(line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(animalRecordData != null) {
            animalRecordDatas.add(animalRecordData);
        }

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return animalRecordDatas;
    }
}
