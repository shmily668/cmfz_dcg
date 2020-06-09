/*
package com.baizhi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PoiTest {
    @Autowired
    private DogMapper dogMapper;


    @Test
    public void excel(){
        //1.创建excel
        HSSFWorkbook workbook = new HSSFWorkbook();
            //设置单元格样式
        HSSFDataFormat dataFormat = workbook.createDataFormat();
        short format = dataFormat.getFormat("yyyy年MM月dd日");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setDataFormat(format);
        //2.创建工作簿
        HSSFSheet sheet = workbook.createSheet("java");
            //设置单元格宽度
        sheet.setColumnWidth(1,20*256);
        //3.行
        HSSFRow row = sheet.createRow(0);
        //4.创建单元格
        HSSFCell cell = row.createCell(0);
        HSSFCell cell1 = row.createCell(1);
        //5.设置单元格值
        cell.setCellValue("丁程刚");
        cell1.setCellValue(new Date());
        cell1.setCellStyle(cellStyle);
        //写出数据
        try {
            workbook.write(new File("D:/poi.xls"));
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    */
/*
 * 导出数据库数据
 * *//*

//    @Test
//    public void sqlOut(){
//        //1.创建excel
//        HSSFWorkbook workbook = new HSSFWorkbook();
//            //字体样式
//        HSSFFont font = workbook.createFont();
//        font.setBold(true);
//        font.setColor(Font.COLOR_RED);
//        HSSFCellStyle cellStyle = workbook.createCellStyle();
//        cellStyle.setFont(font);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//            //设置日期格式
//        HSSFDataFormat dataFormat = workbook.createDataFormat();
//        short format = dataFormat.getFormat("yyyy年MM月dd日");
//        HSSFCellStyle cellStyle1 = workbook.createCellStyle();
//        cellStyle1.setDataFormat(format);
//
//        //2.创建工作簿    指定表格名
//        HSSFSheet sheet = workbook.createSheet("数据导出");
//        //变更单元格长度
//        sheet.setColumnWidth(3,20*256);
//
//        //3.创建行
//        HSSFRow row = sheet.createRow(0);
//
//        //标题
//        String[] titile = {"编号","姓名","年龄","生日"};
//        for (int i = 0; i < titile.length; i++) {
//            String title = titile[i];
//            HSSFCell cell = row.createCell(i);
//            cell.setCellValue(title);
//            cell.setCellStyle(cellStyle);
//        }
//        //添加数据
//        List<Dog> dogs = dogMapper.selectDogs();
//        System.out.println("查询的数据  "+dogs);
//        for (int i = 0; i < dogs.size(); i++) {
//            //创建行
//            HSSFRow row1 = sheet.createRow(i + 1);
//            //创建单元格并赋值
//            row1.createCell(0).setCellValue(dogs.get(i).getId());
//            row1.createCell(1).setCellValue(dogs.get(i).getName());
//            row1.createCell(2).setCellValue(dogs.get(i).getAge());
//            HSSFCell cell = row1.createCell(3);
//            cell.setCellValue(dogs.get(i).getBir());
//            cell.setCellStyle(cellStyle1);
//        }
//
//        //4.写出数据
//        try {
//            workbook.write(new File("D:/sql.xls"));
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    */
/*
 * poi数据导入
 *
 * *//*

    @Test
    public void intSql() throws Exception {
//        // 1. 创建excle文件 并且 读入对应的 excle
//        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream("D:/sql.xls"));
//
//        //2. 获得sheet 工作簿
//        HSSFSheet sheet = workbook.getSheet("数据导出");
//
//        //3. 获取最后一行的下标
//        int lastRowNum = sheet.getLastRowNum();
//        ArrayList<Dog> list = new ArrayList<>();
//        for (int i = 1; i <= lastRowNum; i++) {
//            String id = sheet.getRow(i).getCell(0).getStringCellValue();
//            String name = sheet.getRow(i).getCell(1).getStringCellValue();
//            int age = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
//            Date bir = sheet.getRow(i).getCell(3).getDateCellValue();
//            Dog dog = new Dog(id, name, age, bir);
//            list.add(dog);
//            dogMapper.insertDogAll(list);
//        }
//        System.out.println(list);
    }

}
*/
