package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class BasePage
{
	protected WebDriver driver;
    protected WebDriverWait wait;
    
	public BasePage(WebDriver driver) 
	{
		 if (driver == null) {
		        throw new IllegalStateException(
		            "WebDriver is null when initializing BasePage"
		        );
		    }
		 
		  this.driver = driver; 
	        int waitTime = Integer.parseInt(
	                ConfigReader.get("explicitWait"));	

	        this.wait = new WebDriverWait(
	                driver,
	                Duration.ofSeconds(waitTime));
	        
	}
	
	
	protected void initializeElements() {
		
		 if (this.driver == null) {
		        throw new IllegalStateException(
		            "WebDriver is null during PageFactory initialization"
		        );
		    }

	            PageFactory.initElements(driver, this);
	        }
	
}