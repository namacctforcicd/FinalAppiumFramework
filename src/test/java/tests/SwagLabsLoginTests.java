package tests;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

public class SwagLabsLoginTests extends MobileBaseTest {

    @Test
    public void testSwagLabTest1() throws IOException, InterruptedException {
        //3. Perform actions using appium driver

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.is_LoginButtonDisplayed());
        loginPage.perform_successfulLogin("standard_user", "secret_sauce");

        HomePage homePage = new HomePage();
//        homePage.tapOn_AddToCartItem();
//        homePage.tapOn_CartIcon();
//
//        CartPage cartPage = new CartPage();
//        cartPage.performLeftSwipeAndDeleteItem();

//        WebElement source = getAppiumDriver().findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-Drag Handle\"])[1]/android.widget.TextView"));
//        WebElement target =  getAppiumDriver().findElement(MobileBy.AccessibilityId("test-Cart drop zone"));

//        WebElement source = getAppiumDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name=\"test-Drag Handle\"]/XCUIElementTypeStaticText)[1]"));
//        WebElement target = getAppiumDriver().findElement(By.id("test-Cart drop zone"));


//        Point p1 = source.getLocation();
//        Point p2 = target.getLocation();
//
//        new TouchAction(getAppiumDriver())
//                .press(PointOption.point(p1.getX()+10, p1.getY()+10))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
//                .perform()
//                .moveTo(PointOption.point(p2.getX() + 200, p2.getY() + 15))
//                .release()
//                .perform();

//        TouchAction action = new TouchAction(getAppiumDriver());
//        action.longPress(new ElementOption().withElement(source))
//                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
//                .moveTo(new ElementOption().withElement(target))
//                .release()
//                .perform();


//        new TouchAction(getAppiumDriver())
//                .press(PointOption.point(p1.getX(), p1.getY()))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
//                .perform()
//                .moveTo(PointOption.point(p2.getX(), p2.getY()))
//                .release()
//                .perform();


//        action.longPress(elem1).waitAction(3000).moveTo(elem2).perform().release();


//        WebElement source = getAppiumDriver().findElement(By.xpath("(//XCUIElementTypeOther[@name=\"test-Drag Handle\"]/XCUIElementTypeStaticText)[1]"));
//        WebElement target = getAppiumDriver().findElement(By.id("test-Cart drop zone"));
//
//        perform_DragAndDropAction(source, target);

        swipeDownTo_Element(MobileBy.xpath("//XCUIElementTypeStaticText[@value='Sauce Labs Onesie']"), 10);
//        tapOn_Element(MobileBy.xpath("//XCUIElementTypeStaticText[@value='Sauce Labs Onesie']"));
//
//        swipeDownTo_Element(By.id("test-ADD TO CART"), 10);
//        tapOn_Element(By.id("test-ADD TO CART"));
//        scrollTo_Top();
//        scrollTo_Bottom();
//        swipeUp(2);
//        swipeDown(2);
//        log.info("Error msg: " + login.get_ErrorMsg());

//        Assert.assertEquals(login.get_ErrorMsg(), "Username and password do not match any user in this.", "FAIL: Error message miss matched");

//        Assert.assertTrue(login.is_LoginButtonDisplayed(), "FAIL: Unable to find LOGIN button on screen");
//        Assert.assertTrue(login.is_UserNameDisplayed(), "FAIL: Unable to find LOGIN button on screen");
//        Assert.assertTrue(login.is_PasswordDisplayed(), "FAIL: Unable to find LOGIN button on screen");
//
//        login.perform_successfulLogin("standard_user", "secret_sauce");
//
//        mobile.tapOn_Element(MobileBy.AccessibilityId("test-Toggle"));
//        mobile.takeScreenShot("toggle");
//        mobile.tapOn_Element(MobileBy.xpath("(//XCUIElementTypeStaticText[@name=\"test-Item title\"])[1]"));
//        mobile.takeScreenShot("listview");
//
//        mobile.tapOn_Element(MobileBy.xpath("//XCUIElementTypeOther[@name=\"test-Menu\"]/XCUIElementTypeOther"));
//        mobile.takeScreenShot("productdescription");
//        mobile.tapOn_Element(MobileBy.AccessibilityId("test-LOGOUT"));
//        mobile.takeScreenShot("logout");
//        mobile.waitFor_ElementClickable(MobileBy.AccessibilityId("test-Username"));




        homePage = new HomePage();
        homePage.tapOn_HamburgerMenuIcon();
        MenuPage menuPage = new MenuPage();
        menuPage.tapOn_LogoutOption();
    }

//    @Test
//    public void testSwagLabTest2() throws MalformedURLException, InterruptedException {
//        //3. Perform actions using appium driver
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Username"))).sendKeys("standard_user");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Password"))).sendKeys("secret_sauce");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-LOGIN"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-Menu"))).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("test-LOGOUT"))).click();
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("test-LOGOUT"))));
//    }



}
