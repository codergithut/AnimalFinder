package com.service.impl;

import com.model.AnimalData;
import com.model.ValidationResult;
import com.service.GetShowDataService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by tianjian on 2020/2/29.
 */
public class GetShowDataServiceImpl implements GetShowDataService {
    @Override
    public void getShowDataService(List<AnimalData> animalDatas, List<ValidationResult> validationResults, String checkIndex) {
        Map<String,Integer[]> animalCount = new HashMap<>();
        if(validationResults != null && validationResults.size() > 0) {
            Optional<ValidationResult> validationResult = validationResults.stream().filter(e -> e.getCode().equals(checkIndex)).findAny();
            if(validationResult.isPresent()) {
                System.out.println(validationResult.get().toString());
                return ;
            }
        }
        for(int i = 0; i < animalDatas.size(); i++) {
            boolean flag = false;
            if(animalDatas.get(i).getAnimalCode().equals(checkIndex)) {
                flag = true;
            }
            animalCount.put(animalDatas.get(i).getAnimalCode(), animalDatas.get(i).getCurrentPoint());
            if(flag && !animalDatas.get(i).getAnimalCode().equals(checkIndex)) {
                break;
            }
        }
        for(Map.Entry<String,Integer[]> value : animalCount.entrySet()) {
            System.out.println(value.getKey() + " " + value.getValue()[0] + " " + value.getValue()[1]);
        }
    }
}
