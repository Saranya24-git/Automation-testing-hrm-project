package dataProviders;

import java.io.IOException;
import org.testng.annotations.DataProvider;

import annotations.TestDataSheet;
import java.lang.reflect.Method;
import utils.ExcelUtils;


public class TestDataProvider
{
	@DataProvider(name="TestData")
	public Object[][] provideTestData(Method method) throws IOException
	{
	    ExcelUtils excel = new ExcelUtils();
	    String testCaseId = method.getName().split("_")[0];
	    Class<?> testClass = method.getDeclaringClass();
	    TestDataSheet annotation = testClass.getAnnotation(TestDataSheet.class);
	    String sheetName = annotation.sheetName();
	    Class<?> modelClass = annotation.model();
	    Object data = excel.getTestData(sheetName,testCaseId, modelClass);	  
	    excel.closeWorkbook();

	    return new Object[][]
	    		{
	    		    { data } 
	    		};
	}
}