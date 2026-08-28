package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import config.ConfigReader;

public class DriverFactory { 
        
        public static WebDriver initDriver() {
        	
        	WebDriver driver = null;      

        	String browser = ConfigReader.get("browser");
        	
        	switch (browser.toLowerCase()) {

            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

            driver.manage().window().maximize();

            return driver;
    	}
        
       

		
       
    
}