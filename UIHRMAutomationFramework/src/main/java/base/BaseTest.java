package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;

public class BaseTest
{
	protected WebDriver driver;   
	 @BeforeMethod
 	public void Setup()
 	{
 		driver = DriverFactory.initDriver();
 		driver.get(ConfigReader.getProperty("url"));
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
 	}
	 
	 @AfterMethod
     public void tearDown() {

         if(driver != null)
             driver.quit();
     }

}