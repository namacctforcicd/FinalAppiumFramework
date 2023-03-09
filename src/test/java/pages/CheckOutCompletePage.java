package pages;

import core.drivers.Attributes;
import core.drivers.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckOutCompletePage extends HeaderPage {

    final static Logger log = Logger.getLogger(CheckOutCompletePage.class);

    @iOSXCUITFindBy(accessibility = "THANK YOU FOR YOU ORDER")
    @AndroidFindBy(accessibility = "test-BACK HOME")
    WebElement THANK_YOU_TITLE;

    @iOSXCUITFindBy(accessibility = "Your order has been dispatched, and will arrive just as fast as the pony can get there!")
    @AndroidFindBy(accessibility = "test-BACK HOME")
    WebElement THANK_YOU_DESCRIPTION;

    @iOSXCUITFindBy(accessibility = "test-BACK HOME")
    @AndroidFindBy(accessibility = "test-BACK HOME")
    WebElement BACK_HOME;

    public CheckOutCompletePage() {
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public String getThankYouTitle() {
        return MobileActions.getElementTextByAttribute(THANK_YOU_TITLE, Attributes.NAME);
    }

    public String getThankYouDescription() {
        return MobileActions.getElementTextByAttribute(THANK_YOU_DESCRIPTION, Attributes.NAME);
    }

    public void tapOn_BackHomeButton(){
        MobileActions.tapOn_Element(BACK_HOME);
    }
}
