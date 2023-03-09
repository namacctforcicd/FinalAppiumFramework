package pages;

import core.drivers.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends HeaderPage {

    final static Logger log = Logger.getLogger(ProductDetailsPage.class);

    @iOSXCUITFindBy(accessibility = "test-ADD TO CART")
    @AndroidFindBy(accessibility = "test-ADD TO CART")
    WebElement ADD_TO_CART;

    @iOSXCUITFindBy(accessibility = "test-BACK TO PRODUCTS")
    @AndroidFindBy(accessibility = "test-BACK TO PRODUCTS")
    WebElement BACK_TO_PRODUCTS;

    public ProductDetailsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public void tapOn_AddToCartButton(){
        MobileActions.swipeDownTo_Element(ADD_TO_CART, 30);
        MobileActions.tapOn_Element(ADD_TO_CART);
    }

    public boolean is_TShirtContentDisplayed(String name) {
        MobileActions.swipeDownTo_Element(By.xpath("//XCUIElementTypeStaticText[@name='"+name+"']"), 30);
        return MobileActions.is_ElementDisplayed(By.xpath("//XCUIElementTypeStaticText[@name='"+name+"']"));
    }

    public void tapOn_BackToProductButton() {
        MobileActions.waitFor_ElementAndTap(BACK_TO_PRODUCTS);
    }

}
