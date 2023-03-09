package pages;

import core.drivers.Attributes;
import core.drivers.MobileActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final static Logger log = Logger.getLogger(LoginPage.class);

    public enum PASSWORD { SECRET_SAUCE }

    public enum USERNAMES {
        STANDARD_USER,
        LOCKED_OUT_USER,
        PROBLEM_USER
    }

    @iOSXCUITFindBy(accessibility = "test-Username")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView[1]")
    WebElement SWAGLABS_LOGO;

    @iOSXCUITFindBy(accessibility = "test-Username")
    @AndroidFindBy(accessibility = "test-Username")
    WebElement USERNAME_TEXTFIELD;

    @iOSXCUITFindBy(accessibility = "test-Password")
    @AndroidFindBy(accessibility = "test-Password")
    WebElement PASSWORD_FIELD;

    @iOSXCUITFindBy(accessibility = "test-standard_user")
    @AndroidFindBy(accessibility = "test-standard_user")
    WebElement EST_STANDARD_USER_TEXT;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView")
    WebElement LOGIN_BUTTON;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.widget.ImageView")
    WebElement SWAGLABS_BOT_LOGO;

    @iOSXCUITFindBy(accessibility = "test-LOGIN")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView")
    WebElement USERNAME_MSG_TEXT;

    @iOSXCUITFindBy(accessibility = "Username and password do not match any user in this service.")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    WebElement ERROR_MSG_TEXT;

    @iOSXCUITFindBy(accessibility = "Username and password do not match any user in this service.")
    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"test-Login\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.TextView[2]")
    WebElement PASSWORD_MSG_TEXT;

    public LoginPage() {
        log.info("Initializing in the login page: ");
        PageFactory.initElements(new AppiumFieldDecorator(MobileActions.getAppiumDriver()), this);
    }

    public boolean is_SwagLabsLogoDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(SWAGLABS_LOGO);
    }

    public void enterText_UserNameTextField(String username) {
        log.info("Enter username in the text field: " + username);
        MobileActions.waitFor_ElementClearAndType(USERNAME_TEXTFIELD, username);
    }

    public String getTextFrom_UserNameTextField() {
        String text = MobileActions.getElementTextByAttribute(USERNAME_TEXTFIELD, Attributes.TEXT);
        log.info("Get text from username text field: " + text);
        return text;
    }

    public void enterText_PasswordTextField(String password) {
        log.info("Enter password in the text field: " + password);
        MobileActions.waitFor_ElementClearAndType(PASSWORD_FIELD, password);
    }

    public String getTextFrom_PasswordField() {
        String text = MobileActions.getElementTextByAttribute(PASSWORD_FIELD, Attributes.TEXT);
        log.info("Get text from password field: " + text);
        return text;
    }

    public void tapOn_LoginButton() {
        MobileActions.tapOn_Element(LOGIN_BUTTON);
    }

    public String getTextFrom_ErrorMsg() {
        String text = null;
        if(MobileActions.getAppiumDriver() instanceof IOSDriver)
            text = MobileActions.waitAnd_GetElementByAttribute(ERROR_MSG_TEXT, Attributes.NAME);
        if(MobileActions.getAppiumDriver() instanceof AndroidDriver) {
            text = MobileActions.waitAnd_GetElementByAttribute(ERROR_MSG_TEXT, Attributes.TEXT);
        }
        return text;
    }

    public boolean is_ErrorTextMsgDisplayed() {
        boolean flag = false;
        if(MobileActions.getAppiumDriver() instanceof IOSDriver)
            return MobileActions.waitFor_ElementToBeDisplayed(ERROR_MSG_TEXT);
        if(MobileActions.getAppiumDriver() instanceof AndroidDriver) {
            log.error("I have to figure out the attribute for android here");
        }
        return flag;
    }

    public boolean is_SwagLabsBotLogoDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(SWAGLABS_BOT_LOGO);
    }

    public String getTextFrom_LoginButton() {
        String text = null;
        if(MobileActions.is_AndroidDriver())
            text = MobileActions.getElementTextByAttribute(LOGIN_BUTTON, Attributes.TEXT);
        else if(MobileActions.is_IOSDriver())
            text = MobileActions.getElementTextByAttribute(LOGIN_BUTTON, Attributes.LABEL);
        log.info("Get text on LOGIN button: " + text);
        return text;
    }

    public boolean is_UsernameTextMsgDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(USERNAME_MSG_TEXT);
    }

    public String getTextFrom_UsernameTextMsg() {
        String text = MobileActions.getElementTextByAttribute(USERNAME_MSG_TEXT, Attributes.TEXT);
        log.info("Get username text msg as: " + text);
        return text;
    }

    public void tapOn_UserName(USERNAMES username) {
        MobileActions.waitFor_ElementAndTap(By.xpath("//android.widget.TextView[@text='"+username.name().toLowerCase()+"']"));
    }

    public String getTextFrom_UserName(USERNAMES username) {
        String text = MobileActions.getElementTextByAttribute(By.xpath("//android.widget.TextView[@text='"+username.name().toLowerCase()+"']"), Attributes.TEXT);
        log.info("Get username text as: " + text);
        return text;
    }

    public boolean is_PasswordForAllUsersTextDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(PASSWORD_MSG_TEXT);
    }

    public String getTextFrom_PasswordForAllUsersTextMsg() {
        String text = MobileActions.getElementTextByAttribute(PASSWORD_MSG_TEXT, Attributes.TEXT);
        log.info("Get username text msg as: " + text);
        return text;
    }

    public void tapOn_SecretSaucePassword(PASSWORD password) {
        MobileActions.waitFor_ElementAndTap(By.xpath("////android.widget.TextView[@text='"+password.name().toLowerCase()+"']"));
    }

    public String getTextFrom_SecretSauce(PASSWORD password) {
        String text = MobileActions.getElementTextByAttribute(By.xpath("////android.widget.TextView[@text='"+password.name().toLowerCase()+"']"), Attributes.TEXT);
        log.info("Get password text as: " + text);
        return text;
    }

    public void perform_successfulLogin(String username, String password) {
        enterText_UserNameTextField(username);
        enterText_PasswordTextField(password);
        tapOn_LoginButton();
    }

    public boolean is_UserNameDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(USERNAME_TEXTFIELD);
    }
    public boolean is_PasswordDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(PASSWORD_FIELD);
    }
    public boolean is_LoginButtonDisplayed() {
        return MobileActions.waitFor_ElementToBeDisplayed(LOGIN_BUTTON);
    }

}


