package tests;

import core.readers.ExcelReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class DataProviderTest extends MobileBaseTest{

    @Test (dataProvider = "data")
    public void loginTest(String username, String password) {
        LoginPage login = new LoginPage();
        login.perform_successfulLogin(username, password);
    }

    @DataProvider(name = "data")
    public Object[][] testData() {
        ExcelReader.initWorkBook();
        return ExcelReader.getDataFromSheetName("Sheet1");
    }

}
