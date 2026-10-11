package reporting;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IExecutionListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.DriverFactory;

//Connect TestNG's execution life cycle to ExtentReports
public class ExtentReportListener
        implements ITestListener, IExecutionListener {

    private ExtentReports extent;

    @Override
    public void onExecutionStart() {

    	extent = ExtentManager.getInstance(
        		"reports/ui-extent-report.html",
                "OrangeHRM UI Automation"
        );
    }

    @Override
    public void onTestStart(ITestResult result) {

        String testName =
            result.getTestClass().getRealClass().getSimpleName()
            + " :: "
            + result.getMethod().getMethodName();

        ExtentTest test = extent.createTest(testName);

        ExtentTestManager.setTest(test);

        test.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        recordAndClear(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	
    	 ExtentTest test = ExtentTestManager.getTest();
    	 try {
    	        WebDriver driver = DriverFactory.getDriver();

    	        if (driver != null && test != null) {

    	            // Create screenshots folder
    	            Path screenshotDir =
    	                Paths.get("reports", "screenshots");

    	            Files.createDirectories(screenshotDir);

    	            // Generate screenshot filename
    	            String screenshotFileName =
    	                result.getTestClass().getRealClass().getSimpleName()
    	                + "_"
    	                + result.getMethod().getMethodName()
    	                + "_"
    	                + System.currentTimeMillis()
    	                + ".png";

    	            // Avoid invalid filename characters
    	            screenshotFileName =
    	                screenshotFileName.replaceAll(
    	                    "[^a-zA-Z0-9._-]", "_"
    	                );

    	            // Capture screenshot
    	            File source =
    	                ((TakesScreenshot) driver)
    	                    .getScreenshotAs(OutputType.FILE);

    	            // Save screenshot permanently
    	            Path destination =
    	                screenshotDir.resolve(screenshotFileName);

    	            Files.copy(
    	                source.toPath(),
    	                destination,
    	                StandardCopyOption.REPLACE_EXISTING
    	            );

    	            // Attach screenshot to ExtentReports
    	            test.addScreenCaptureFromPath(
    	                "screenshots/" + screenshotFileName
    	            );
    	        }

    	    } catch (Exception e) {
    	        if (test != null) {
    	            test.info(
    	                "Screenshot capture failed: " + e.getMessage()
    	            );
    	        }
    	    }

         // Record failure and clear current test reference
        recordAndClear(result);       
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        recordAndClear(result);
    }

    private void recordAndClear(ITestResult result) {
        ExtentTestManager.recordResult(result);
        ExtentTestManager.clear();
    }

    @Override
    public void onExecutionFinish() {
        ExtentManager.flush();
    }
}