package com.zyj.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zyj.excel.data.DemoData;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelMain {
    public static void main(String[] args) {
        // 写法1
        String fileName = "E:\\simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());

        // 写法2
        fileName = "E:\\simpleWrite" + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写
        ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, DemoData.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(data(), writeSheet);
        } finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    public static List data() {
        List<DemoData> list = new ArrayList<DemoData>();
        DemoData data1 = new DemoData("a", new Date(), 1.0);
        DemoData data2 = new DemoData("b", new Date(), 2.0);
        DemoData data3 = new DemoData("c", new Date(), 3.0);
        list.add(data1);
        list.add(data2);
        list.add(data3);
        return list;
    }
}
