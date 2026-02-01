package com.bank.Utility;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelUtils {
public static Object[][] getExcelData(String sheetName){
    try{
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\LoginDetails.xlsx");
        Workbook wb= WorkbookFactory.create(fis);
        System.out.println("Sheet requested: "+sheetName);
        Sheet sheet=wb.getSheet(sheetName);
        if (sheet==null){
            throw new RuntimeException("Sheet not found: "+sheetName+". Please check Excel sheet name");
        }
        int rows=sheet.getPhysicalNumberOfRows();
        int cols=sheet.getRow(0).getPhysicalNumberOfCells();
        Object[][] data=new Object[rows-1][cols];
        for (int i=1;i<rows;i++){
            for (int j=0;j<cols;j++){
                data[i-1][j]=sheet.getRow(i).getCell(j).toString();
            }
        }
                wb.close();
        return data;
    }catch (Exception e){
        throw new RuntimeException("Failed to read excel", e);
    }
}
}
