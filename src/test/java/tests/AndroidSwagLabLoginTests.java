package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSwagLabLoginTests extends MobileBaseTest{

    @Test
    public void testSwagLabTest() throws MalformedURLException, InterruptedException {

//        //1.  Capabilities
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("platformName", "android");
//        capabilities.setCapability("automationName", "UIAutomator2");
//        capabilities.setCapability("deviceName", "127.0.0.1:62001");
//        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
//        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
//        capabilities.setCapability("noReset", true);
//
//        //2. Create appium driver
//        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        //3. Perform actions using appium driver
        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.is_LoginButtonDisplayed());
        loginPage.perform_successfulLogin("standard_user", "secret_sauce");


        pauseExecutionForSeconds(3);
        ProductsPage pp =new ProductsPage();
        pp.clickOnAddToCart1();
        pauseExecutionForSeconds(2);

      //  pp.clickingCart();
        pp.clickMenuButton();

        pauseExecutionForSeconds(2);
        MenuPage menu = new MenuPage();

        menu.tapOn_LogoutOption();
        pauseExecutionForSeconds(2);
      //  getAppiumDriver().quit();


    }
}
