package pages;

import core.drivers.MobileActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends HeaderPage {

    final static Logger log = Logger.getLogger(CartPage.class);

    @iOSXCUITFindBy(accessibility = "test-CHECKOUT")
    @AndroidFindBy(accessibility = "test-CHECKOUT")
    WebElement CHECKOUT_BUTTON;

    @iOSXCUITFindBy(accessibility = "test-Delete")
    @AndroidFindBy(accessibility = "test-Delete")
    WebElement DELETE_BUTTON;

    public CartPage(){
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public void tapOn_CheckOut(){
        MobileActions.tapOn_Element(CHECKOUT_BUTTON);
    }

    public void performLeftSwipeAndDeleteItem() {
        MobileActions.performSwipeLeftJS(DELETE_BUTTON);
        MobileActions.waitFor_ElementClickable(DELETE_BUTTON);
        MobileActions.tapOn_Element(DELETE_BUTTON);
    }
}
