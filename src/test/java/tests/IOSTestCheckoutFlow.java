package tests;

import constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class IOSTestCheckoutFlow extends MobileBaseTest {

    @Test
    public void test() {
        extentReport.getTest().info("This is my first report");
        extentReport.captureScreenShotInReport();

        LoginPage loginPage = new LoginPage();

        Assert.assertTrue(loginPage.getTextFrom_LoginButton().equals(AppConstants.Login.LOGIN_BUTTON_TEXT));
        extentReport.getTest().info("Login page loaded successfully");
        extentReport.captureScreenShotInReport();
        loginPage.perform_successfulLogin("standard_user", "secret_sauce");
        extentReport.getTest().info("Signed in successfully");

        HomePage homePage = new HomePage();
        extentReport.getTest().info("Tap on filter icon");
        homePage.tapOn_FilterIcon();
        homePage.tapOn_FilterOption(HomePage.FilterOptions.PRICE_HIGH_TO_LOW);
        extentReport.getTest().info("Filtering the results from high to low");
        homePage.tapOn_AddToCartItem();
        homePage.tapOn_CartIcon();
        extentReport.getTest().info("Added item to the cart");
//
//        CartPage cartPage = new CartPage();
//        cartPage.tapOn_CheckOut();
//
//        CheckOutPage checkOut = new CheckOutPage();
//        checkOut.type_Information("Williams", "abcd" ,"12345");
//
//        CheckOutOverViewPage checkOutOverViewPage = new CheckOutOverViewPage();
//        checkOutOverViewPage.tapOn_FinishButton();
//
//        CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();
//        System.out.println(checkOutCompletePage.getThankYouTitle());
//        System.out.println(checkOutCompletePage.getThankYouDescription());
//        checkOutCompletePage.tapOn_BackHomeButton();
//
        homePage.tapOn_HamburgerMenuIcon();
        extentReport.getTest().info("Menu page for logout");
        extentReport.captureScreenShotInReport();
        MenuPage menuPage = new MenuPage();
        menuPage.tapOn_MenuOption(MenuPage.Options.LOGOUT);

        loginPage.is_LoginButtonDisplayed();

    }

    @Test
    public void test2() {
        extentReport.getTest().info("This is my first report");
        extentReport.captureScreenShotInReport();

        LoginPage loginPage = new LoginPage();

        Assert.assertTrue(loginPage.getTextFrom_LoginButton().equals(AppConstants.Login.LOGIN_BUTTON_TEXT));
        extentReport.getTest().info("Login page loaded successfully");
        extentReport.captureScreenShotInReport();
        loginPage.perform_successfulLogin("standard_user", "secret_sauce");
        extentReport.getTest().info("Signed in successfully");

        HomePage homePage = new HomePage();
        extentReport.getTest().info("Tap on filter icon");
        homePage.tapOn_FilterIcon();
        homePage.tapOn_FilterOption(HomePage.FilterOptions.PRICE_HIGH_TO_LOW);
        extentReport.getTest().info("Filtering the results from high to low");
        homePage.tapOn_AddToCartItem();
        homePage.tapOn_CartIcon();
        extentReport.getTest().info("Added item to the cart");
//
//        CartPage cartPage = new CartPage();
//        cartPage.tapOn_CheckOut();
//
//        CheckOutPage checkOut = new CheckOutPage();
//        checkOut.type_Information("Williams", "abcd" ,"12345");
//
//        CheckOutOverViewPage checkOutOverViewPage = new CheckOutOverViewPage();
//        checkOutOverViewPage.tapOn_FinishButton();
//
//        CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();
//        System.out.println(checkOutCompletePage.getThankYouTitle());
//        System.out.println(checkOutCompletePage.getThankYouDescription());
//        checkOutCompletePage.tapOn_BackHomeButton();
//
        homePage.tapOn_HamburgerMenuIcon();
        extentReport.getTest().info("Menu page for logout");
        extentReport.captureScreenShotInReport();
        MenuPage menuPage = new MenuPage();
        menuPage.tapOn_MenuOption(MenuPage.Options.LOGOUT);

        loginPage.is_LoginButtonDisplayed();

    }

}
