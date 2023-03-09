package pages;

import core.drivers.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverViewPage extends HeaderPage {

    final static Logger log = Logger.getLogger(LoginPage.class);

    @iOSXCUITFindBy(accessibility = "test-FINISH")
    @AndroidFindBy(accessibility = "test-FINISH")
    WebElement FINISH_BUTTON;

    public CheckOutOverViewPage() {
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public void tapOn_FinishButton(){
        MobileActions.swipeDownTo_Element(FINISH_BUTTON, 60);
        MobileActions.tapOn_Element(FINISH_BUTTON);
    }
}
