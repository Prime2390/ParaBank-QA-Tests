package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.models.RegisterModelFaker;
import DominikBernas.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest  extends BaseTest {
    @Test
    public void loginTestWithValidData(){
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        WebElement overviewHeader = new HomePage(driver)
                .loginWithCorrectData(firstUserModel)
                .getAccountsOverviewHeader();
        Assert.assertEquals(overviewHeader.getText(), "Accounts Overview");
    }
    @Test
    public void loginTestWithInvalidData(){
        RegisterModelFaker registerModelFaker = new RegisterModelFaker();

       WebElement error = new HomePage(driver)
                .loginWithIncorrectData(registerModelFaker)
                .getErrorMessage();
        Assert.assertEquals(error.getText(), "An internal error has occurred and has been logged.");
    }
    @Test
    public void loginTestWithoutDana(){
        WebElement error = new HomePage(driver)
                .clickLoginButton()
                .getErrorMessage();
        System.out.println(error.getText());
        Assert.assertEquals(error.getText(), "Please enter a username and password.");
    }
}
