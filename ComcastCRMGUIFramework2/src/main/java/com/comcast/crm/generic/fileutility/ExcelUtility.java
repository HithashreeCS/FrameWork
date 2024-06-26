package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/vtigertestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		String data = sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		
		return data;
	}

	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./testdata/vtigertestScript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		
		return rowcount;

	}

	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws Throwable {

		FileInputStream fis=new FileInputStream("./testdata/vtigertestScript.xlsx");
			
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testdata/vtigertestScript.xlsx");
		wb.write(fos);
		wb.close();
		
	}
}
