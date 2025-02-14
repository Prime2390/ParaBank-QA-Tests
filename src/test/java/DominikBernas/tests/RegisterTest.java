package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.RegisterModelFaker;
import DominikBernas.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void registerWithValidData() {
        RegisterModelFaker registerModelFaker = new RegisterModelFaker();
        WebElement welcome = new HomePage(driver)
                .clickRegisterButton()
                .registerWithValidData(registerModelFaker)
                .clickRegisterButtonWithInvalidData()
                .getTitle();
        Assert.assertTrue(welcome.getText().contains("Welcome"));
    }
}
