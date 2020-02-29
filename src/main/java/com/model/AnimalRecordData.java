package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tianjian on 2020/2/29.
 */
public class AnimalRecordData {

    /**
     * 记录编码
     */
    private String recordCode;

    /**
     * 发现时间
     */
    private Date happyTime;

    /**
     * 时间字符串
     */
    private String time;

    /**
     * 具体数据
     */
    private List<String> data = new ArrayList<>();

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public Date getHappyTime() {
        return happyTime;
    }

    public void setHappyTime(Date happyTime) {
        this.happyTime = happyTime;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void addDatas(String data) {
        this.data.add(data);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
