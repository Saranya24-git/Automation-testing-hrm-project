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
		 String browser = ConfigReader.get("browser");

		 boolean headless =Boolean.parseBoolean(ConfigReader.get("headless"));

		 driver = DriverFactory.createDriver(browser, headless);
		 
		 driver.get(ConfigReader.get("url"));	
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
 	}
	 
	 @AfterMethod
     public void tearDown() {

        DriverFactory.quitDriver(driver);
     }

}