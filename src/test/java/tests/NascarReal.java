package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.springframework.remoting.support.DefaultRemoteInvocationExecutor;
import org.testng.annotations.Test;

public class NascarReal extends MobileBaseTest {

  // AndroidDriver driver = null;
    // https://www.browserstack.com/guide/top-appium-commands
   IOSDriver driver = null;

   @Test(enabled = false)
   public void androidFirstTest() {
      getAppiumDriver();

      WebElement navButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("Open navigation drawer"));
      navButton.click();
      pauseExecutionForSeconds(2);

      WebElement driverLink = getAppiumDriver().findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[8]/android.widget.TextView"));
      driverLink.click();
      pauseExecutionForSeconds(2);

      WebElement truckLink = getAppiumDriver().findElement(MobileBy.AccessibilityId("NASCAR Craftsman Truck Series"));
      truckLink.click();
      pauseExecutionForSeconds(2);

      WebElement rajaCaruth = getAppiumDriver().findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[3]/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
      rajaCaruth.click();

      // driver.executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));


    //  driver.pressKey();
     // driver.pressKey(AndroidKey.HOME);

     // driver.pressKey(AndroidKey.HOME);
     // final AndroidKey home = AndroidKey.HOME;
       pauseExecutionForSeconds(2);
       getAppiumDriver().closeApp();


   }
   @Test(enabled = false)
   public void iOSFirstTest(){
      getAppiumDriver();

      WebElement navButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("Open navigation menu"));
      navButton.click();
      pauseExecutionForSeconds(2);

     WebElement driveLink = getAppiumDriver().findElement(MobileBy.AccessibilityId("DRIVERS"));
      driveLink.click();
      pauseExecutionForSeconds(2);

      WebElement truckLink = getAppiumDriver().findElement(MobileBy.AccessibilityId("Switch to NASCAR Craftsman Truck Series"));
      truckLink.click();
      pauseExecutionForSeconds(2);

      WebElement rajaCaruth = getAppiumDriver().findElement(MobileBy.AccessibilityId("Rajah Caruth"));
      rajaCaruth.click();
       pauseExecutionForSeconds(3);

       WebElement backArrow = getAppiumDriver().findElement(MobileBy.xpath("//XCUIElementTypeButton[@name=\"Drivers\"]"));
       backArrow.click();

      getAppiumDriver().executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));



   }

   @Test(enabled = false)
    public void secondiOSTest() throws NullPointerException{
       getAppiumDriver();

       WebElement navButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("Open navigation menu"));
       navButton.click();
       pauseExecutionForSeconds(2);

       // go to tracks
       WebElement trackButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("TRACKS"));
       trackButton.click();
       pauseExecutionForSeconds(2);
       //scroll down to Watkins Glen


       try {
           //Check this example - https://www.automationtestinghub.com/appium-scroll-examples/
           WebElement watkinsGlenTrack = getAppiumDriver().findElement(MobileBy.AccessibilityId("Watkins Glen International"));
           swipeDownTo_Element(watkinsGlenTrack, 5);


           // watkinsGlenTrack.click();
           pauseExecutionForSeconds(2);

           // WebElement wwtr = getAppiumDriver().findElement(MobileBy.AccessibilityId("World Wide Technology Raceway"));
//      swipeDownTo_Element(wwtr,5);
//      watkinsGlenTrack.click();

//       TouchActions action = new TouchActions(driver);
//       action.scroll(watkinsGlenTrack, 52, 377);
//       action.perform();
       }catch(StaleElementReferenceException sere){
           sere.printStackTrace();
           System.out.println("Watkins Glen is visible");
       }

       getAppiumDriver().executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));

   }

   @Test()
    public void secondAndroidTest(){

       getAppiumDriver();

//       WebElement noThanks = getAppiumDriver().findElement(MobileBy.id("com.nascar.nascarmobile:id/cancelView"));
//       if(noThanks.isDisplayed()){
//           noThanks.click();
//       }

       WebElement navButton = getAppiumDriver().findElement(MobileBy.AccessibilityId("Open navigation drawer"));
       navButton.click();
       pauseExecutionForSeconds(2);

       WebElement trackButton = getAppiumDriver().findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[9]"));
       trackButton.click();

       pauseExecutionForSeconds(3);
       //scrollTo_Bottom();
      // swipeDown(5);
      // scrollDown(0,1888);
      // scrollDownMethod(1779,1947);

       mobileScrollVertical("Watkins Glen International");
       //    driver.findElement(By.xpath("//android.widget.ImageButton[@bounds='[9,288][144,318]']")); --  //android.widget.LinearLayout[@bounds='[0,1608][1080,1776]']
     //  WebElement watkinsGlenButton = getAppiumDriver().findElement(MobileBy.xpath("//android.widget.LinearLayout[@bounds='[144,1667][1044,1717]']"));
       WebElement watkinsGlenButton = getAppiumDriver().findElement(MobileBy.xpath("//android.widget.LinearLayout[@bounds='[0,1608][1080,1776]']"));
      // WebElement watkinsGlenButton = getAppiumDriver().findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[8]"));
      // getAppiumDriver().findElementByAndroidUIAutomator(“new UiScrollable(new UiSelector()).scrollIntoView(text(“Enter your element”))”);
      // WebElement watkinsGlenButton = getAppiumDriver().findElement(MobileBy.xpath("//android.widget.LinearLayout[@index=‘7’]"));
     //  WebElement watkinsGlenButton = getAppiumDriver().findElement(MobileBy.xpath("//android.widget.LinearLayout[7]"));
       watkinsGlenButton.click();

       pauseExecutionForSeconds(3);
       getAppiumDriver().closeApp();
      // swipeDownTo_Element(watkinsGlenButton, 4);
   }

   @Test(enabled = false)
    public void androidThirdTest(){

       getAppiumDriver();

       WebElement standings = getAppiumDriver().findElement(MobileBy.xpath("//android.widget.FrameLayout[@content-desc=\"Standings\"]/android.widget.FrameLayout/android.widget.ImageView"));
       standings.click();

       WebElement xfinitySeries = getAppiumDriver().findElement(MobileBy.AccessibilityId("Xfinity Series"));
       xfinitySeries.click();

       WebElement mfrStandings = getAppiumDriver().findElement(MobileBy.xpath("//android.widget.LinearLayout[@content-desc=\"Manufacturer\"]/android.widget.TextView"));
       mfrStandings.click();

     //  getAppiumDriver().executeScript("mobile: pressButton", ImmutableMap.of("name", "home"));
       pauseExecutionForSeconds(4);
       getAppiumDriver().closeApp();
   }
}
