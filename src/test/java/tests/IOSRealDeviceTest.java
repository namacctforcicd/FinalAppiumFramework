package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSRealDeviceTest  extends MobileBaseTest {

    @Test
    public void realiOSTest() {

         // Sample app -  "com.huynh.felixpro"

   getAppiumDriver();

        WebElement numFive = getAppiumDriver().findElement(MobileBy.AccessibilityId("5"));
        numFive.click();
        WebElement multiplyButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("multiply"));
        multiplyButton.click();
        WebElement numSix = getAppiumDriver().findElement(MobileBy.AccessibilityId("6"));
        numSix.click();
        WebElement equalButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("equals"));
        equalButton.click();

        pauseExecutionForSeconds(3);
        WebElement clearButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("clear"));
        clearButton.click();
        pauseExecutionForSeconds(2);

        getAppiumDriver().executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));

}
}
