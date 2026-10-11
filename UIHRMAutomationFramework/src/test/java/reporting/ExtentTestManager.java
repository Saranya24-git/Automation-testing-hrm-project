package reporting;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> TEST =
        new ThreadLocal<>();

    private ExtentTestManager() {
    }

    public static void setTest(ExtentTest test) {
        TEST.set(test);
    }

    public static ExtentTest getTest() {
        return TEST.get();
    }

    public static void recordResult(ITestResult result) {

        ExtentTest test = TEST.get();

        if (test == null) {
            return;
        }

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            if (result.getThrowable() != null) {
                test.fail(result.getThrowable());
            } else {
                test.fail("Test failed");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            if (result.getThrowable() != null) {
                test.skip(result.getThrowable());
            } else {
                test.skip("Test skipped");
            }
        }
    }

    public static void clear() {
        TEST.remove();
    }
}