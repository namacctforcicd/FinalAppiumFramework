package tests;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import core.drivers.MobileActions;
import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestResult;
import org.testng.annotations.*;
import reporting.ExtentReport;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class MobileBaseTest extends MobileActions {

    static {
        PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "config" +File.separator+ "log4j.properties");
    }

    public ExtentReport extentReport = null;

    @BeforeSuite
    public void beforeSuite() {
        extentReport = new ExtentReport();
    }

    @Parameters({"appiumServerURL", "device"})
    @BeforeMethod
    public void beforeTest(Method method, String appiumServerURL, String device) throws MalformedURLException {
        extentReport.setTestName(method.getName());
        MobileActions.initMobileDriver(device, appiumServerURL);
    }

    @AfterTest
    public void afterTest() {
        getAppiumDriver().quit();
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        if(result.getStatus()==ITestResult.FAILURE) {
            extentReport.getTest().addScreenCaptureFromPath(takeScreenShot());
            extentReport.getTest().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAIL", ExtentColor.RED));
            extentReport.getTest().fail(result.getThrowable());
        }
        else if(result.getStatus()==ITestResult.SUCCESS) {
            extentReport.getTest().addScreenCaptureFromPath(takeScreenShot());
            extentReport.getTest().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASS", ExtentColor.TEAL));
        }
        else if(result.getStatus()==ITestResult.SKIP) {
            extentReport.getTest().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIP", ExtentColor.ORANGE));
        }
    }

    @AfterSuite
    public void afterSuite() {
        if(extentReport != null)
            extentReport.getReport().flush();
    }

//    public AppiumDriver getMobileDriver() {
//        return driver;
//    }
//
//    public WebDriverWait getWait() {
//        return MobileDriver.getWait();
//    }


}
