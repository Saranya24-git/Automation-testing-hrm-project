package reporting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {
    }

    public static synchronized ExtentReports getInstance(
            String reportPath, String projectName) {

        if (extent == null) {
            try {
                Files.createDirectories(
                    Paths.get(reportPath).toAbsolutePath().getParent()
                );
            } catch (IOException e) {
                throw new RuntimeException(
                    "Unable to create report directory", e
                );
            }

            ExtentSparkReporter spark =
                new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle(projectName);
            spark.config().setReportName(projectName);

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", projectName);
            extent.setSystemInfo("Framework", "Java + TestNG");
        }

        return extent;
    }

    public static synchronized void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}