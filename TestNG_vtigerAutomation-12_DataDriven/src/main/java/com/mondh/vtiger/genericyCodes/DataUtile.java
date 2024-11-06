package com.mondh.vtiger.genericyCodes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataUtile {

	public static void main(String[] args) {
		DataUtile data = new DataUtile();
		data.getTestCaseData("VT003", 2);
	}

	public Map<String, String> getTestCaseData(String tcID, int testCasecolumnNumber) {
		Workbook wBook = null;
		int tcNumber = -1;
		try {
			// access data file.
			FileInputStream dataFile = new FileInputStream("src\\test\\resources\\dataExcel.xlsx");
			wBook = new XSSFWorkbook(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetObj = wBook.getSheet("DataSheet");
		int tcRowNumber = getRowNumberByTestcase(sheetObj, tcID, testCasecolumnNumber);
		Row rowObj = sheetObj.getRow(tcRowNumber);
		Map<String, String> datamap = new HashMap<String, String>();
		int cellcount = rowObj.getLastCellNum();
		for (int i = 3; i <= cellcount - 1; i = i + 2) {
//		String cellDataKey=rowObj.getCell(i,MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
//		String cellDataValue=rowObj.getCell(i+1,MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

			String cellDataKey = getcellDataType(rowObj, i);
			String cellDataValue = getcellDataType(rowObj, i + 1);
			datamap.put(cellDataKey, cellDataValue);
		}
		return datamap;
	}

	public int getRowNumberByTestcase(Sheet sheetObj, String tcID, int columnNumber) {
		// below lines will search for testcase id in data sheet
		// and will given row number where data exist
		int tcNumber = -1;
		for (int i = 1; i <= sheetObj.getLastRowNum(); i++) {
			Row rowObj = sheetObj.getRow(i);
			Cell cellObj = rowObj.getCell(columnNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
			String cellData = cellObj.getStringCellValue();
			if (cellData.equalsIgnoreCase(tcID)) {
				tcNumber = i;
				break;
			}
		}
		return tcNumber;
	}

	// thismethod will read from excel on the basis of row object and cell number
	// it will manage data whether it is in string or integer.
	public String getcellDataType(Row rowObj, int cellNumber) {
		String data = null;
		Cell cellObj = rowObj.getCell(cellNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK);
		if (cellObj.getCellType() == CellType.STRING) {
			data = cellObj.getStringCellValue();
		} else if (cellObj.getCellType() == CellType.NUMERIC) {
			Double dbl = cellObj.getNumericCellValue();
			Integer intData = dbl.intValue();
			data = intData.toString();
		}
		return data;
	}

	public String getRowDataByTestcase(String tcID) {
		
		String celldata = null;
		Workbook wBook = null;
		try {
			// access data file.
			FileInputStream dataFile = new FileInputStream("src\\test\\resources\\dataExcel.xlsx");
			wBook = new XSSFWorkbook(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheetObj = wBook.getSheet("DataSheet");
		for (int i = 1; i <= sheetObj.getLastRowNum(); i++) {
			Row rowObj = sheetObj.getRow(i);
			for(int j=3;j<=rowObj.getLastCellNum()-1;j++) {
					String	cellData =getcellDataType(rowObj,j);
				if (cellData.equalsIgnoreCase(tcID)) {
					celldata = cellData;
					break;
				}
			}
		}
		return celldata;
	}

}
