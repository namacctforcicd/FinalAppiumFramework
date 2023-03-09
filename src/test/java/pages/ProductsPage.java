package pages;

import core.drivers.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends HeaderPage {
    final static Logger log = Logger.getLogger(ProductsPage.class);

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")
    WebElement sauceLabsBackPack;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "(//android.widget.TextView[@content-desc=\"test-Item title\"])[2]")
    WebElement sauceLabsBikeLight;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement cartIcon;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement menuButton;

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    WebElement modalButton;// brings up sort by menu

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Toggle\"]/android.widget.ImageView")
    WebElement toggleButton;// switches views for product page

    @iOSXCUITFindBy()
    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]/android.widget.TextView")
    WebElement add_To_Cart1;// For sauceLabsBackPack

    public ProductsPage(){
        log.info("Initializing for the Products page: ");
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }


    public void clickOnAddToCart1(){
        add_To_Cart1.click();
    }

    public void clickingCart(){
        cartIcon.click();
    }

    public void clickMenuButton(){
        menuButton.click();
    }


}
