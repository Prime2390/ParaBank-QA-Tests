package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.models.RegisterModelFaker;
import DominikBernas.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CustomerLookupTest extends BaseTest {
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

    @Test
    public void customerLookupWithInvalidData() {
        RegisterModelFaker registerModelFaker = new RegisterModelFaker();
        WebElement Error = new HomePage(driver)
                .forgotLoginInfo()
                .enterCastomerLookupWithInvalidData(registerModelFaker)
                .getErrorMessage();
        System.out.println(Error.getText());
    }

    @Test
    public void customerLookupWithoutData() {
        List<String> Errors = new HomePage(driver)
                .forgotLoginInfo()
                .ForgotLoginButton()
                .getErrorMessages();
        Assert.assertTrue(Errors.get(0).contains("First name is required."));
        Assert.assertTrue(Errors.get(1).contains("Last name is required."));
        Assert.assertTrue(Errors.get(2).contains("Address is required."));
        Assert.assertTrue(Errors.get(3).contains("City is required."));
        Assert.assertTrue(Errors.get(4).contains("State is required."));
        Assert.assertTrue(Errors.get(5).contains("Zip Code is required."));
        Assert.assertTrue(Errors.get(6).contains("Social Security Number is required."));
        System.out.println(Errors.get(0));
        System.out.println(Errors.get(1));
        System.out.println(Errors.get(2));
        System.out.println(Errors.get(3));
        System.out.println(Errors.get(4));
        System.out.println(Errors.get(5));
        System.out.println(Errors.get(6));

    }
}
