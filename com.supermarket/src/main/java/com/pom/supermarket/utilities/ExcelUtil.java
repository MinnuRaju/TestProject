package com.pom.supermarket.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	XSSFSheet sheet;
	XSSFSheet sh;
	public String readData(int i,int j) {
		Row r=sh.getRow(i);	
		Cell c=r.getCell(j);
		int cell=c.getCellType();//1
		switch(cell) {
		case Cell.CELL_TYPE_NUMERIC:
		{
			
			double d=c.getNumericCellValue();
			return String.valueOf(d);
		}
		case Cell.CELL_TYPE_STRING:{
			return c.getStringCellValue();
		}
		}
		return null;

		
	}
	public  ExcelUtil() throws IOException {
		FileInputStream fp=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resource\\ExcelFile\\TestData.xlsx");
		XSSFWorkbook wb =new XSSFWorkbook(fp);
		sh=wb.getSheet("Sheet1");
	}



}
