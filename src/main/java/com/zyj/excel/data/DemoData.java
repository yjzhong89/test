package com.zyj.excel.data;

import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(Double doubleData) {
        this.doubleData = doubleData;
    }

    public DemoData(String string, Date date, Double doubleData) {
        this.string = string;
        this.date = date;
        this.doubleData = doubleData;
    }
}
