package com.model;

import java.util.Date;

/**
 * Created by tianjian on 2020/2/29.
 */
public class AnimalData {

    /**
     * 动物编号
     */
    private String animalCode;

    /**
     * 发现时间
     */
    private Date findDate;

    /**
     * 当前位置
     */
    private Integer[] currentPoint;

    /**
     * 记录编码
     */
    private String recordCodes;


    public String getAnimalCode() {
        return animalCode;
    }

    public void setAnimalCode(String animalCode) {
        this.animalCode = animalCode;
    }

    public Date getFindDate() {
        return findDate;
    }

    public void setFindDate(Date findDate) {
        this.findDate = findDate;
    }

    public Integer[] getCurrentPoint() {
        return currentPoint;
    }

    public void setCurrentPoint(Integer[] currentPoint) {
        this.currentPoint = currentPoint;
    }

    public String getRecordCodes() {
        return recordCodes;
    }

    public void setRecordCodes(String recordCodes) {
        this.recordCodes = recordCodes;
    }
}
