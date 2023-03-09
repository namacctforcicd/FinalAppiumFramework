package tests;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class BarnesNobleReal extends MobileBaseTest{

    @Test
    public void firstAndroidTest(){
        getAppiumDriver();
        getAppiumDriver().activateApp("bn.ereader");

//        WebElement bobAl = getAppiumDriver().findElement(MobileBy.AccessibilityId("Miracle: Bobby Allison and the Saga of the Alabama Gang"));
//        mobileScrollHorizontal();
//        bobAl.click();

       // mobileScrollHorizontal();
      //  performSwipeRightJS();
        WebElement recommendedArea = getAppiumDriver().findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View"));
        recommendedArea.click();
        WebElement datasci = getAppiumDriver().findElement(MobileBy.AccessibilityId("Data Science Strategy For Dummies"));
        mobileScrollHorizontal();

        datasci.click();
    }

    @Test
    public void firstiOSTest(){
        getAppiumDriver();
        
    }
}
