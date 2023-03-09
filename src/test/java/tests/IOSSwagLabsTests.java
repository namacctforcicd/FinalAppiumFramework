package tests;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSSwagLabsTests extends MobileBaseTest {

    @Test
    public void iOSRealRealDeviceTest() throws MalformedURLException, InterruptedException {
//        MutableCapabilities caps = new MutableCapabilities();
//        caps.setCapability("platformName", "Android");
//        caps.setCapability("appium:app", "storage:filename=sl.apk");
//        caps.setCapability("appium:deviceName", "Samsung.*");
//        caps.setCapability("appium:automationName", "UiAutomator2");
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//        sauceOptions.setCapability("build", "android-build");
//        sauceOptions.setCapability("name", "android-name");
//        caps.setCapability("sauce:options", sauceOptions);
//
//        URL url = new URL("https://appiumstudent:5e06ddea-63ba-47d1-8833-c05088ef82c9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
//        AndroidDriver driver = new AndroidDriver(url, caps);

        Thread.sleep(5000);

        LoginPage loginPage = new LoginPage();
        loginPage.perform_successfulLogin("standard_user", "secret_sauce");

//        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys("standard_user");
//        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys("secret_sauce");
//        driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']/android.widget.TextView")).click();

        Thread.sleep(5000);

        WebElement source = MobileActions.getAppiumDriver().findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[1]/android.widget.TextView"));
        WebElement target =  MobileActions.getAppiumDriver().findElement(MobileBy.AccessibilityId("test-Cart drop zone"));

        TouchAction action = new TouchAction(MobileActions.getAppiumDriver());
        action.longPress(new ElementOption().withElement(source))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
                .moveTo(new ElementOption().withElement(target))
                .release()
                .perform();

        Thread.sleep(5000);

        MobileActions.getAppiumDriver().quit();

    }


}
