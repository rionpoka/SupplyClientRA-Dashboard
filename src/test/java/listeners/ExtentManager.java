package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
    public static ExtentReports extent;
    public static ExtentTest test;

    public static void setupReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void endReport() {
        extent.flush();
    }
}
