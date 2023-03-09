package pages;

import core.drivers.Attributes;
import core.drivers.MobileActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends HeaderPage {

    final static Logger log = Logger.getLogger(HomePage.class);

    public enum FilterOptions {
        NAME_A_TO_Z,
        NAME_Z_TO_A,
        PRICE_LOW_TO_HIGH,
        PRICE_HIGH_TO_LOW,
        CANCEL
    }

    @iOSXCUITFindBy(accessibility = "test-Toggle")
    @AndroidFindBy(accessibility = "test-Toggle")
    WebElement TOGGLE_LIST_ICON;

    @iOSXCUITFindBy(accessibility = "test-Modal Selector Button")
    @AndroidFindBy(accessibility = "test-Toggle")
    WebElement FILTER_ICON;

    @iOSXCUITFindBy(accessibility = "test-Image Container")
    @AndroidFindBy(accessibility = "test-Image Container")
    WebElement ITEMS;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeOther[@name=\"test-ADD TO CART\"])[1]")
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])")
    public WebElement ADD_TO_CART_BUTTON;

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public void tapOn_AddToCartItem(){
        log.info("Select the item Sauce Labs Backpack");
        MobileActions.tapOn_Element(ADD_TO_CART_BUTTON);
    }

    public void tapOn_FilterIcon(){
        log.info("Tap on filter icon");
        MobileActions.waitFor_ElementAndTap(FILTER_ICON);
    }

    public void tapOn_ListToggleIcon(){
        log.info("Tap on list toggle icon");
        MobileActions.waitFor_ElementAndTap(TOGGLE_LIST_ICON);
    }

    public void tapOn_FilterOption(FilterOptions filterOption) {
        String option = filterOption.name().replace("_", " ").toLowerCase() ;
        if(option.contains("a to z"))
            option = "Name (A to Z)";
        else if(option.contains("z to a"))
            option = "Name (Z to A)";
        else if(option.contains("low to high"))
            option = "Price (low to high)";
        else if(option.contains("high to low"))
            option = "Price (high to low)";
        else if(option.contains("cancel"))
            option = "Cancel";
        if(MobileActions.is_IOSDriver())
            MobileActions.tapOn_Element(By.xpath("//XCUIElementTypeOther[@label='" + option + "']"));

        MobileActions.pauseExecutionForSeconds(3);
    }

    public void getAllPrices() {
        List<WebElement> prices = MobileActions.getAppiumDriver().findElements(MobileBy.xpath("//XCUIElementTypeStaticText[@name='test-Price']"));
        for(WebElement price: prices) {
            log.info("Price is: " + MobileActions.getElementTextByAttribute(price, Attributes.VALUE));
        }
    }

    public void getAllTShirtNames() {
        List<WebElement> prices = MobileActions.getAppiumDriver().findElements(MobileBy.xpath("//XCUIElementTypeStaticText[@name='test-Item title']"));
        for(WebElement price: prices) {
            log.info("Price is: " + MobileActions.getElementTextByAttribute(price, Attributes.VALUE));
        }
    }

    public void tapOn_ShirtByDisplayName(String name) {
        MobileActions.swipeDownTo_Element(By.xpath("//XCUIElementTypeStaticText[@label='"+name+"']"), 30);
        MobileActions.tapOn_Element(By.xpath("//XCUIElementTypeStaticText[@label='"+name+"']"));
    }

}
