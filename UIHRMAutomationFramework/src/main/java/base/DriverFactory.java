package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory { 
        
        public static WebDriver createDriver(String browser, boolean headless) {
        	
        	WebDriver driver;
        	
        	switch (browser.toLowerCase()) {

            case "chrome":
            	ChromeOptions chromeOptions = new ChromeOptions();

                if (headless)
                    chromeOptions.addArguments("--headless=new");

                driver =  new ChromeDriver(chromeOptions);      
                break;

            case "edge":
            	EdgeOptions edgeOptions = new EdgeOptions();

                if (headless)
                    edgeOptions.addArguments("--headless=new");

               driver =  new EdgeDriver(edgeOptions);
               break;

            case "firefox":
            	 FirefoxOptions firefoxOptions = new FirefoxOptions();

                 if (headless)
                     firefoxOptions.addArguments("--headless");

                 driver =  new FirefoxDriver(firefoxOptions);
                 break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        	if (headless) {
        	    driver.manage().window().setSize(new Dimension(1920, 1080));
        	}
        	else {
        	    driver.manage().window().maximize();
        	}
        	return driver;
        }
        
        public static void quitDriver(WebDriver driver) {

            if (driver != null) {
                driver.quit();
            }
        }
}

