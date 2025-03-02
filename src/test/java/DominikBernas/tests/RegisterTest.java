package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.models.RegisterModelFaker;
import DominikBernas.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterTest extends BaseTest {
    @Test
    public void registerWithValidData() {
        RegisterModelFaker registerModelFaker = new RegisterModelFaker();
        WebElement welcome = new HomePage(driver)
                .clickRegisterButton()
                .registerWithValidData(registerModelFaker)
                .clickRegisterButtonWithValidData()
                .getTitle();
        Assert.assertTrue(welcome.getText().contains("Welcome"));
    }

    @Test
    public void registerWithoutData() {
        List<String> errors = new HomePage(driver)
                .clickRegisterButton()
                .clickRegisterButtonWithInvalidData()
                .getErrorMessages();
        Assert.assertEquals(errors.size(), 10);
        Assert.assertEquals(errors.get(0), "First name is required.");
        Assert.assertEquals(errors.get(1), "Last name is required.");
        Assert.assertEquals(errors.get(2), "Address is required.");
        Assert.assertEquals(errors.get(3), "City is required.");
        Assert.assertEquals(errors.get(4), "State is required.");
        Assert.assertEquals(errors.get(5), "Zip Code is required.");
        Assert.assertEquals(errors.get(6), "Social Security Number is required.");
        Assert.assertEquals(errors.get(7), "Username is required.");
        Assert.assertEquals(errors.get(8), "Password is required.");
        Assert.assertEquals(errors.get(9), "Password confirmation is required.");

    }

    @Test
    public void registerWithDifferentPassword() {
        RegisterModelFaker registerModelFaker = new RegisterModelFaker();

        List<String> errorMessages = new HomePage(driver)
                .clickRegisterButton()
                .registerWithDifferentPassword(registerModelFaker)
                .clickRegisterButtonWithInvalidData()
                .getErrorMessages();

        Assert.assertEquals(errorMessages.get(0), "Passwords did not match.");
    }

    @Test
    public void registerWithSameUsername() {
        FirstUserModel firstUserModel = new FirstUserModel();

        List<String> Error = new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton()
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithInvalidData()
                .getErrorMessages();

        System.out.println(Error.size());
        System.out.println(Error.get(0));
        Assert.assertEquals(Error.get(0), "This username already exists.");
    }
}
