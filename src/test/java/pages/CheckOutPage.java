package pages;

import core.drivers.MobileActions;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends HeaderPage {

    final static Logger log = Logger.getLogger(CheckOutPage.class);

    @iOSXCUITFindBy(accessibility = "test-First Name")
    @AndroidFindBy(accessibility = "test-First Name")
    WebElement First_Name;

    @iOSXCUITFindBy(accessibility = "test-Last Name")
    @AndroidFindBy(accessibility = "test-Last Name")
    WebElement Last_Name;

    @iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    WebElement Zip_Code;

    @iOSXCUITFindBy(accessibility = "CANCEL")
    @AndroidFindBy(accessibility = "CANCEL")
    WebElement CANCEL_BUTTON;

    @iOSXCUITFindBy(accessibility = "test-CONTINUE")
    @AndroidFindBy(accessibility = "test-CONTINUE")
    WebElement CONTINUE_BUTTON;

    public CheckOutPage(){
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public void enterText_FirstName(String firstname){ MobileActions.waitFor_ElementAndType(First_Name, firstname); }

    public void enterText_LastName(String lastname){MobileActions.typeOn_Element(Last_Name, lastname);}

    public void enterNumber_ZipCode(String zipcode) {MobileActions.typeOn_Element(Zip_Code, zipcode);}

    public void tapOn_ContinueButton(){
        MobileActions.tapOn_Element(CONTINUE_BUTTON);
    }

    public void tapOn_CancelButton(){MobileActions.tapOn_Element(CANCEL_BUTTON);}

    public void type_Information(String firstname, String lastname, String zipcode){
        log.info("Enter the information:" + firstname + lastname + zipcode);
        enterText_FirstName(firstname);
        enterText_LastName(lastname);
        enterNumber_ZipCode(zipcode);
        tapOn_ContinueButton();
    }
}
