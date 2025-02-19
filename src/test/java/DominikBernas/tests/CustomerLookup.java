package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.models.RegisterModelFaker;
import DominikBernas.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CustomerLookup extends BaseTest {
    @Test
    public void customerLookupWithValidData() {
        FirstUserModel firstUserModel = new FirstUserModel();

        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        WebElement info = new HomePage(driver)
                .forgotLoginInfo()
                .enterCastomerLookupWithValidData(firstUserModel)
                .getUsername();
        Assert.assertTrue(info.isDisplayed());
        org.testng.Assert.assertEquals(info.getText(), "Username: Tester2390\n" +
                "Password: Testerpass2390");
    }
}
