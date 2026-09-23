package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class BasePage
{
	protected WebDriver driver;
    protected WebDriverWait wait;
    
	public BasePage(WebDriver driver) 
	{
		driver = DriverFactory.getDriver();

	        int waitTime = Integer.parseInt(
	                ConfigReader.get("explicitWait"));

	        this.wait = new WebDriverWait(
	                driver,
	                Duration.ofSeconds(waitTime));
	}
}