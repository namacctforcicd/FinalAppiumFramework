package pages;

import core.drivers.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    final static Logger log = Logger.getLogger(HeaderPage.class);

    @iOSXCUITFindBy(accessibility = "test-Menu")
    @AndroidFindBy(accessibility = "test-Menu")
    WebElement HAMBURGER_MENU_ICON;

    @iOSXCUITFindBy(accessibility = "test-Cart")
    @AndroidFindBy(accessibility = "test-Cart")
    WebElement CART_ICON;

    public HeaderPage() {
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public void tapOn_HamburgerMenuIcon() {
        MobileActions.waitFor_ElementAndTap(HAMBURGER_MENU_ICON);
    }

    public void tapOn_CartIcon() {
        MobileActions.swipeDownTo_Element(CART_ICON, 30);
        MobileActions.tapOn_Element(CART_ICON);
    }

}
