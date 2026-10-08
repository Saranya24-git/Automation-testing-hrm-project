package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import config.ConfigReader;

public class BaseTest
{
	protected WebDriver driver;   
	
	private static final Logger logger =
	        LogManager.getLogger(BaseTest.class);
	
	 @BeforeMethod
 	public void Setup()
 	{
		 logger.info(
		            "Starting test: {} | Thread: {}",
		            getClass().getSimpleName(),
		            Thread.currentThread().getId());
		 
		 String browser = ConfigReader.get("browser");

		 boolean headless =Boolean.parseBoolean(ConfigReader.get("headless"));
		 
		 DriverFactory.createDriver(browser, headless);

		 driver = DriverFactory.getDriver();
		 
		 logger.info(
		            "Navigating to URL: {}",
		            ConfigReader.get("url"));
		 
		 driver.get(ConfigReader.get("url"));	
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
 	}
	 
	 @AfterMethod
     public void tearDown() {

		 logger.info(
		            "Ending test: {} | Thread: {}",
		            getClass().getSimpleName(),
		            Thread.currentThread().getId());
        DriverFactory.quitDriver(driver);
     }

}