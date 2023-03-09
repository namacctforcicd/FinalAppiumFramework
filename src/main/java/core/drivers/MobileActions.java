package core.drivers;

import core.readers.ReadCapabilityFromJSON;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MobileActions {

    final static Logger log = Logger.getLogger(MobileActions.class);

    private static AppiumDriver appium = null;
    private static WebDriverWait wait = null;
    private static DesiredCapabilities capabilities = null;

    public static void initMobileDriver(String deviceConfig, String appiumServerURL) {
        capabilities = ReadCapabilityFromJSON.getDeviceCapabilities(deviceConfig + ".json");
        log.info("Capabilities successfully initialized");
//        capabilities.setJavascriptEnabled(true);
//        capabilities.setCapability("appium:setJavascriptEnabled", true);// appium version 1
        try {
            if (ReadCapabilityFromJSON.is_IOSDriver()) {
                appium = new IOSDriver(new URL(appiumServerURL), capabilities);
                log.info("IOS driver initialized");
            } else if (ReadCapabilityFromJSON.is_AndroidDriver()) {
                appium = new AndroidDriver(new URL(appiumServerURL), capabilities);
                log.info("Android driver initialized");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }
        appium.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(appium, 300);
        log.info("WebDriverWait 'wait' initialized with wait object");
    }

    public static AppiumDriver getAppiumDriver() {
        if (appium == null)
            log.error("appium driver is null, please call 'initMobileDriver' method to initialize it");
        return appium;
    }

    public static WebDriverWait getWebDriverWait() {
        if (getAppiumDriver() != null) {
            if (wait == null) {
                wait = new WebDriverWait(getAppiumDriver(), 300);
                log.info("WebDriverWait 'wait' was null initialized again");
            } else {
                log.info("Returned 'wait' object");
            }
        } else {
            log.error("AppiumDriver object 'appium' is null");
        }
        return wait;
    }

    public static boolean is_IOSDriver() {
        if (getAppiumDriver() instanceof IOSDriver)
            return true;
        else
            return false;
    }

    public static boolean is_AndroidDriver() {
        if (getAppiumDriver() instanceof AndroidDriver)
            return true;
        else
            return false;
    }

    public static WebElement waitFor_ElementClickable(WebElement e) {
        log.info("Waiting for element: " + e.toString());
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(e));
    }

    public static WebElement waitFor_ElementClickable(By by) {
        log.info("Waiting for element by: " + by.toString());
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(getAppiumDriver().findElement(by)));
    }

    public static void tapOn_Element(WebElement e) {
        log.info("Tap on element: " + e.toString());
        e.click();
    }

    public static void tapOn_Element(By by) {
        log.info("Tap on element by: " + by.toString());
        getAppiumDriver().findElement(by).click();
    }

    public static void waitFor_ElementAndTap(WebElement e) {
        log.info("Tap on element: " + e.toString());
        waitFor_ElementClickable(e).click();
    }

    public static void waitFor_ElementAndTap(By by) {
        log.info("Tap on element by: " + by.toString());
        waitFor_ElementClickable(by).click();
    }

    public static void typeOn_Element(WebElement e, String text) {
        log.info("Type in element: " + e.toString() + " text: " + text);
        e.sendKeys(text);
    }

    public static void waitAnd_TypeOnElement(WebElement e, String text) {
        log.info("Type in element: " + e.toString() + " text: " + text);
        waitFor_ElementClickable(e).sendKeys(text);
    }

    public static void typeOn_Element(By by, String text) {
        log.info("Type in element: " + by.toString() + " text: " + text);
        getAppiumDriver().findElement(by).sendKeys(text);
    }

    public static void waitAnd_TypeOnElement(By by, String text) {
        log.info("Type in element: " + by.toString() + " text: " + text);
        waitFor_ElementClickable(getAppiumDriver().findElement(by)).sendKeys(text);
    }

    public static void waitFor_ElementClearAndType(WebElement e, String text) {
        log.info("Type in element: " + e.toString() + " text: " + text);
        waitFor_ElementClickable(e).clear();
        e.sendKeys(text);
    }

    public static void waitFor_ElementAndType(WebElement e, String text) {
        log.info("Type in element: " + e.toString() + " text: " + text);
        waitFor_ElementClickable(e).sendKeys(text);
    }

    public static void waitFor_ElementAndType(By by, String text) {
        log.info("Type in element: " + by.toString() + " text: " + text);
        waitFor_ElementClickable(by).sendKeys(text);
    }

    public static void quitApp() {
        log.info("Quiting the running app");
        getAppiumDriver().quit();
    }

    public static boolean is_ElementDisplayed(WebElement e) {
        log.info("Validating isElementDisplayed on screen: " + e.toString());
        return e.isDisplayed();
    }

    public static boolean is_ElementDisplayed(By by) {
        log.info("Validating isElementDisplayed on screen: " + by.toString());
        return getAppiumDriver().findElement(by).isDisplayed();
    }

    public static boolean waitFor_ElementToBeDisplayed(WebElement e) {
        log.info("Waiting and validating isElementDisplayed on screen: " + e.toString());
        return waitFor_ElementClickable(e).isDisplayed();
    }

    public static boolean waitFor_ElementToBeDisplayed(By by) {
        log.info("Waiting and validating isElementDisplayed on screen: " + by.toString());
        return waitFor_ElementClickable(by).isDisplayed();
    }

    public static String getElementTextByAttribute(WebElement e, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        if (a.contains("_"))
            a = a.replace("_", "-");
        log.info("Get element text by attribute '" + a + "': " + e.toString());
        String value = null;
        try {
            value = e.getAttribute(a);
        } catch (WebDriverException ee) {
            log.info("Attribute: " + a + " error: NOT FOUND");
        }
        return value;
    }

    public static String waitAnd_GetElementByAttribute(WebElement e, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        if (a.contains("_"))
            a = a.replace("_", "-");
        log.info("Wait and get element text by attribute '\"+a+\"': " + e.toString());
        String value = null;
        try {
            value = waitFor_ElementClickable(e).getAttribute(a);
        } catch (WebDriverException ee) {
            log.info("Attribute: " + a + " error: NOT FOUND");
        }
        return value;
    }

    public static String getElementTextByAttribute(By by, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        log.info("Get element text by attribute '\"+a+\"': " + by.toString());
        return getAppiumDriver().findElement(by).getAttribute(a);
    }

    public static String waitAnd_GetElementTextByAttribute(By by, Attributes attribute) {
        String a = attribute.name().toLowerCase();
        log.info("Wait and get element text by attribute '\"+a+\"': " + by.toString());
        return waitFor_ElementClickable(by).getAttribute(a);
    }

    public static void takeScreenShot(String fileName) {
        String currentTimeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String SCREENSHOTS_PATH = System.getProperty("user.dir") + File.separator + "output" + File.separator + "screenshots" + File.separator + fileName + currentTimeStamp + ".png";
        File file = ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(SCREENSHOTS_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Screenshot successfully captured in this location: " + SCREENSHOTS_PATH);
    }

    public static String takeScreenShot() {
        String currentTimeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        String SCREENSHOTS_PATH = System.getProperty("user.dir") + File.separator + "output" + File.separator + "reporting" + File.separator + "screenshots" + File.separator + currentTimeStamp + ".png";
        String REPORT_SCREENSHOT_PATH = "./screenshots/" + currentTimeStamp + ".png";
        File file = ((TakesScreenshot) getAppiumDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, new File(SCREENSHOTS_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("Screenshot successfully captured in this location: " + SCREENSHOTS_PATH);
        return REPORT_SCREENSHOT_PATH;
    }

    public static List<String> getAllAttributeNames(WebElement e) {
        List<String> attr = new ArrayList<>();
        String[] names = Arrays.toString(Attributes.values()).replaceAll("^.|.$", "").split(", ");
        for (String name : names) {
            if (name.contains("_"))
                name = name.replace("_", "-");
            name = name.toLowerCase();
            try {
                log.info("Attribute: " + name + " value: " + e.getAttribute(name));
                attr.add(name);
            } catch (WebDriverException ee) {
                log.info("Attribute: " + name + " error: NOT FOUND");
            }
        }
        log.info("All Attributes: " + attr);
        return attr;
    }

    public static List<String> getAllAttributeNames(By by) {
        WebElement e = getAppiumDriver().findElement(by);
        List<String> attr = new ArrayList<>();
        String[] names = Arrays.toString(Attributes.values()).replaceAll("^.|.$", "").split(", ");
        for (String name : names) {
            if (name.contains("_"))
                name = name.replace("_", "-");
            name = name.toLowerCase();
            try {
                log.info("Attribute: " + name + " value: " + e.getAttribute(name));
                attr.add(name);
            } catch (WebDriverException ee) {
                log.info("Attribute: " + name + " error: NOT FOUND");
            }
        }
        log.info("All Attributes: " + attr);
        return attr;
    }

    public static boolean is_AttributeExists(WebElement e, String attribute) {
        String value = null;
        try {
            value = waitFor_ElementClickable(e).getAttribute(attribute);
            log.info("Attribute: " + attribute + " value is: " + value);
        } catch (WebDriverException ee) {
            log.info("Attribute: " + attribute + " error: NOT FOUND");
        }
        if (value != null)
            return true;
        else
            return false;
    }

    public static boolean is_AttributeExists(By by, String attribute) {
        String value = null;
        try {
            value = waitFor_ElementClickable(by).getAttribute(attribute);
            log.info("Attribute: " + attribute + " value is: " + value);
        } catch (WebDriverException ee) {
            log.info("Attribute: " + attribute + " error: NOT FOUND");
        }
        if (value != null)
            return true;
        else
            return false;
    }

    public static void pauseExecutionForSeconds(int seconds) {
        for (int a = seconds; a >= 0; a--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Test execution resume in: " + a + " Seconds");
        }
    }

    public static boolean swipeDownTo_Element(WebElement e, int timeoutSeconds) {
        boolean flag = false;
        WebDriverWait w = new WebDriverWait(getAppiumDriver(), 4);
        for (int i = 0; i <= timeoutSeconds; i++) {
            try {
                if (w.until(ExpectedConditions.visibilityOf(e)).isDisplayed()) {
                    flag = true;
                    log.info("Element is visible: " + e.toString());
                    break;
                }
            } catch (TimeoutException ee) {
                Map<String, Object> args = new HashMap<>();
                args.put("direction", "up");
                getAppiumDriver().executeScript("mobile: swipe", args);
                log.info("Element is not visible scrolling down");
                pauseExecutionForSeconds(3);
            }
        }
        return flag;
    }

    public static boolean swipeDownTo_Element(By by, int timeoutSeconds) {
        boolean flag = false;
        WebDriverWait w = new WebDriverWait(getAppiumDriver(), 3);
        for (int i = 0; i <= timeoutSeconds; i++) {
            try {
                if (w.until(ExpectedConditions.visibilityOf(getAppiumDriver().findElement(by))).isDisplayed()) {
                    flag = true;
                    log.info("Element is visible: " + by.toString());
                    break;
                }
            } catch (TimeoutException ee) {
                Map<String, Object> args = new HashMap<>();
                args.put("direction", "up");
                getAppiumDriver().executeScript("mobile: swipe", args);
                log.info("Element is not visible scrolling down");
                pauseExecutionForSeconds(1);
            }
        }
        return flag;
    }

    public static boolean swipeUpTo_Element(WebElement e, int timeoutSeconds) {
        boolean flag = false;
        WebDriverWait w = new WebDriverWait(getAppiumDriver(), 3);
        for (int i = 0; i <= timeoutSeconds; i++) {
            try {
                if (w.until(ExpectedConditions.visibilityOf(e)).isDisplayed()) {
                    flag = true;
                    log.info("Element is visible: " + e.toString());
                    break;
                }
            } catch (TimeoutException ee) {
                Map<String, Object> args = new HashMap<>();
                args.put("direction", "down");
                getAppiumDriver().executeScript("mobile: swipe", args);
                log.info("Element is not visible scrolling up");
                pauseExecutionForSeconds(1);
            }
        }
        return flag;
    }

    public static boolean swipeUpTo_Element(By by, int timeoutSeconds) {
        boolean flag = false;
        WebDriverWait w = new WebDriverWait(getAppiumDriver(), 3);
        for (int i = 0; i <= timeoutSeconds; i++) {
            try {
                if (w.until(ExpectedConditions.visibilityOf(getAppiumDriver().findElement(by))).isDisplayed()) {
                    flag = true;
                    log.info("Element is visible: " + by.toString());
                    break;
                }
            } catch (TimeoutException ee) {
                Map<String, Object> args = new HashMap<>();
                args.put("direction", "down");
                getAppiumDriver().executeScript("mobile: swipe", args);
                log.info("Element is not visible scrolling up");
                pauseExecutionForSeconds(1);
            }
        }
        return flag;
    }

    public static void scrollTo_Top() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "up");
        getAppiumDriver().executeScript("mobile: scroll", args);
        log.info("Scroll to top of the screen");
    }

    public static void scrollTo_Bottom() {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "down");
        getAppiumDriver().executeScript("mobile: scroll", args);
        log.info("Scroll to bottom of the screen");
    }

    public static void swipeDown(int numberOfTimes) {
        for (int i = 1; i <= numberOfTimes; i++) {
            Map<String, Object> args = new HashMap<>();
            args.put("direction", "up");
            getAppiumDriver().executeScript("mobile: swipe", args);
            log.info("Swipe to down");
            pauseExecutionForSeconds(1);
        }
    }

    public static void swipeUp(int numberOfTimes) {
        for (int i = 1; i <= numberOfTimes; i++) {
            Map<String, Object> args = new HashMap<>();
            args.put("direction", "down");
            getAppiumDriver().executeScript("mobile: swipe", args);
            log.info("Swipe to up");
            pauseExecutionForSeconds(1);
        }
    }

    public static void performSwipeLeftJS(WebElement element) {
        //swipe left on element
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((MobileElement) element).getId());
        args.put("direction", "left");
        appium.executeScript("mobile:swipe", args);
    }

    public static void performSwipeRightJS(WebElement element) {
        //swipe right on element
        Map<String, Object> args = new HashMap<>();
        args.put("element", ((MobileElement) element).getId());
        args.put("direction", "right");
        appium.executeScript("mobile:swipe", args);
    }

    public static void performSwipeLeftJS() {
        //swipe left
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "left");
        appium.executeScript("mobile:swipe", args);
    }

    public static void performSwipeRightJS() {
        //swipe right
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "right");
        appium.executeScript("mobile:swipe", args);
    }

    public static void switchToWebView() {
        log.info(" ---> Requested to changed the view to -> WEB ");
        String context = getCurrentView();
        log.info(" ---> Print the current view = " + context);

        Set<String> views = getAppiumDriver().getContextHandles();
        for (String v : views) {
            if (v.startsWith("WEB")) {
                getAppiumDriver().context(v);
                log.info(" *** SWITCHED TO WEB VIEW *** ");
            }
            if (v.startsWith("CHROMIUM")) {
                getAppiumDriver().context(v);
                log.info(" *** SWITCHED TO CHROMIUM VIEW *** ");
            }
        }
        log.info(" Request completed");
        log.info(" ---> Now the current view = " + getCurrentView());
    }

    public static void switchToNativeView() {
        log.info(" ---> Requested to changed the view to -> NATIVE ");
        String context = getCurrentView();
        log.info(" ---> Print the current view = " + context);

        Set<String> views = getAppiumDriver().getContextHandles();
        for (String v : views) {
            if (v.startsWith("NATIVE")) {
                getAppiumDriver().context(v);
                log.info(" *** SWITCHED TO NATIVE VIEW *** ");
            }
        }
        log.info(" Request completed");
        log.info(" ---> Now the current view = " + getCurrentView());
    }

    public static String getCurrentView() {
        return getAppiumDriver().getContext();
    }

    public static void scrollDown(int scrollStart, int scrollEnd) {
        Dimension dimension = getAppiumDriver().manage().window().getSize();
        scrollStart = (int) (dimension.getHeight() * 0.5);
        scrollEnd = (int) (dimension.getHeight() * 0.2);

        new TouchAction<>((PerformsTouchActions) getAppiumDriver())
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }


    public static void scrollDownMethod(int startYCoordinate, int endYCoordinate) {
        //http://code2test.com/appium-tutorial/vertical-and-horizontal-swipe-scroll-in-appium/#:~:text=Vertical%20and%20horizontal%20scrolling%2Fswipe,y%20co%20ordinates%20changes%20simultaneously.

        TouchAction action = new TouchAction(getAppiumDriver());
        Dimension size = getAppiumDriver().manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        startYCoordinate = (int) (height * .7);
        endYCoordinate = (int) (height * .2);

        action.press(PointOption.point(middleOfX, startYCoordinate))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
    }


    public static void mobileScrollVertical(String text) {
        // https://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-layout-direction/
        MobileElement element = (MobileElement) getAppiumDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                        ".scrollIntoView(new UiSelector().text(\"+" +text+" + \"))"));

    }

    public static void mobileScrollHorizontal(){
        MobileElement element = (MobileElement) getAppiumDriver().findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).setAsHorizontalList()" +
                        ".scrollIntoView(new UiSelector().text(\"Data Science Strategy For Dummies\"))"));
    }
}