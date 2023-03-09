package tests;

import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.MutableCapabilities;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabTests extends MobileBaseTest{

    @Test
    public void saucyAndroidTest() throws MalformedURLException {
        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("platformName","Android");
        caps.setCapability("appium:deviceName","Android GoogleAPI Emulator");
        caps.setCapability("appium:deviceOrientation", "portrait");
        caps.setCapability("appium:platformVersion","11.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", "storage:filename=sl.apk");
        MutableCapabilities sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("build", "appium-build-R5XU2");
        sauceOptions.setCapability("name", "Sauce_appium2");
        caps.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://appiumstudent:5e06ddea-63ba-47d1-8833-c05088ef82c9@ondemand.us-west-1.saucelabs.com:443/wd/hub");
        AppiumDriver driver = new AndroidDriver(url, caps);

        LoginPage lp = new LoginPage();
        lp.enterText_UserNameTextField("standard_user");
        pauseExecutionForSeconds(2);
        lp.enterText_PasswordTextField("secret_sauce");
        pauseExecutionForSeconds(3);

        MobileActions.getAppiumDriver().quit();

    }
}
