package tests;

import core.drivers.MobileActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class IOSWebTest extends MobileBaseTest {

    @Test (priority = 1, enabled = false, groups = {"facebook","webviews"})
    public void test() {
        getAppiumDriver().get("https://facebook.com");
//        pauseExecutionForSeconds(5);

        // 1. print the view -> WEB
        // 2. switch to NATIVE
        // 3. print the current view -> NATIVE
        // 4. Again switch back to WEB view
        // 5. print the current view -> WEB


        // 1. print the view -> WEB
        String context = getAppiumDriver().getContext();
        System.out.println(" ---> Print the current view = " + context);

        // 2. switch to NATIVE
        Set<String> views = getAppiumDriver().getContextHandles();

        for(String v: views) {
            if(v.startsWith("NATIVE")) {
                getAppiumDriver().context(v);
                System.out.println(" *** SWITCHED TO NATIVE VIEW *** ");
            }
            System.out.println(" # Available views -> " + v);
        }

        // 3. print the current view -> NATIVE
        context = getAppiumDriver().getContext();
        System.out.println(" ---> Print the current view = " + context);

        // 4. Again switch back to WEB view
        for(String v: views) {
            if (v.startsWith("WEB")) {
                getAppiumDriver().context(v);
                System.out.println(" *** SWITCHED TO WEB VIEW *** ");
            }
        }

        // 5. print the current view -> WEB
        context = getAppiumDriver().getContext();
        System.out.println(" ---> Print the current view = " + context);

        getAppiumDriver().findElement(MobileBy.xpath("//input[@id='m_login_email']")).sendKeys("praveenashapure");
        getAppiumDriver().findElement(MobileBy.xpath("//input[@id='m_login_password']")).sendKeys("praveenashapure");
        getAppiumDriver().findElement(By.xpath("//button[@name='login']")).click();

        pauseExecutionForSeconds(5);

        getAppiumDriver().quit();
    }

    @Test(priority = 2)
    public void testWebTest() {
        getAppiumDriver().get("https://facebook.com");
//        pauseExecutionForSeconds(5);

        // 1. print the view -> WEB
        // 2. switch to NATIVE
        // 3. print the current view -> NATIVE
        // 4. Again switch back to WEB view
        // 5. print the current view -> WEB

        // 1. print the view -> WEB
        System.out.println(" ---> Print the current view = " + MobileActions.getCurrentView());

        MobileActions.pauseExecutionForSeconds(15);

        MobileActions.switchToNativeView();

        // 4. Again switch back to WEB view
        MobileActions.switchToWebView();

        getAppiumDriver().findElement(MobileBy.xpath("//input[@id='m_login_email']")).sendKeys("praveenashapure");
        getAppiumDriver().findElement(MobileBy.xpath("//input[@id='m_login_password']")).sendKeys("praveenashapure");
        getAppiumDriver().findElement(By.xpath("//button[@name='login']")).click();

        pauseExecutionForSeconds(5);

        getAppiumDriver().quit();
    }

}
