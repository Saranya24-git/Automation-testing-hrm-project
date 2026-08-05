package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.PathConstants;

public class ExcelUtils
{
	 private XSSFWorkbook workbook;
	 private DataFormatter formatter = new DataFormatter();	
	 
	public ExcelUtils() throws IOException
	{
	    FileInputStream fis = new FileInputStream(PathConstants.TEST_DATA_PATH);
	    workbook = new XSSFWorkbook(fis);
	    fis.close();
	}
	
	public int getRowCount(String sheetName)
	{

	    Sheet sheet = workbook.getSheet(sheetName);

	    return sheet.getLastRowNum();
	}

	public int getColumnCount(String sheetName)
	{
		Sheet sheet = workbook.getSheet(sheetName);

	    Row row = sheet.getRow(0);

	    return row.getLastCellNum();
	}
	
	public <T> T getTestData(String sheetName,String testCaseId, Class<T> modelClass) 
		{
			
			Sheet sheet = workbook.getSheet(sheetName);			
			int totalRows = sheet.getLastRowNum();
			int totalColumns = sheet.getRow(0).getLastCellNum();
			for(int i=1;i<=totalRows;i++)
			{
				Row row = sheet.getRow(i);
				Cell cell = row.getCell(0);
				String currentTestCaseId = formatter.formatCellValue(cell);	
				if(currentTestCaseId.equals(testCaseId))
				{	
					T dataObject;
					try
					{
					   dataObject = modelClass.getDeclaredConstructor().newInstance();					
					   for(int j=1;j<totalColumns;j++)
					   {
						   Cell headerCell = sheet.getRow(0).getCell(j);
						   String headerName = formatter.formatCellValue(headerCell);
						   Cell currentCell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);	
						   String cellValue = formatter.formatCellValue(currentCell);
						   String setterMethodName = "set" + headerName;
						   Method setterMethod = modelClass.getMethod(setterMethodName,String.class);
						   setterMethod.invoke(dataObject, cellValue);						
					   }	
						return dataObject;	
					}
					catch(Exception e)
					{
						 throw new RuntimeException("Unable to map Excel data to "+ modelClass.getSimpleName(),e);
					}
				 }
			}				
		throw new RuntimeException("Test Case ID '" + testCaseId + "' not found in sheet '" + sheetName + "'");
		
	}
			
	
	public void closeWorkbook() throws IOException
	{
	    workbook.close();
	}
}
