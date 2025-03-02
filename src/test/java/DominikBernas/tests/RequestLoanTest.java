package DominikBernas.tests;

import DominikBernas.basetest.BaseTest;
import DominikBernas.models.FirstUserModel;
import DominikBernas.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestLoanTest extends BaseTest {

    @Test
    public void requestLoanWithValidData() {
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        String Approved = new HomePage(driver)
                .loginWithCorrectData(firstUserModel)
                .clickRequestLoanLink()
                .applyForLoan("500", "100")
                .getRequestLoanApproved();
        System.out.println(Approved);
        Assert.assertEquals(Approved, "Congratulations, your loan has been approved.");
    }

    @Test
    public void requestLoanWithoutData() {
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        WebElement Error = new HomePage(driver)
                .loginWithCorrectData(firstUserModel)
                .clickRequestLoanLink()
                .applyForLoan("", "")
                .getErrorMessage();

        Assert.assertEquals(Error.getText(), "An internal error has occurred and has been logged.");
    }

    @Test
    public void requestLoanWithNegativeAmount() {
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        WebElement error = new HomePage(driver)
                .loginWithCorrectData(firstUserModel)
                .clickRequestLoanLink()
                .applyForLoan("-5000", "-1000")
                .getErrorTitle();
        Assert.assertEquals(error.getText(), "We cannot grant a loan in that amount with your available funds.");
    }

    @Test
    public void requestLoanWithTooManyFunds() {
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        WebElement error = new HomePage(driver)
                .loginWithCorrectData(firstUserModel)
                .clickRequestLoanLink()
                .applyForLoan("5000000", "1000000")
                .getErrorTitle();
        Assert.assertEquals(error.getText(), "You do not have sufficient funds for the given down payment.");

    }

    @Test
    public void requestLoanWithValidDataWithLetters() {
        FirstUserModel firstUserModel = new FirstUserModel();
        new HomePage(driver)
                .clickRegisterButton()
                .registerWithSameUsername(firstUserModel)
                .clickRegisterButtonWithValidData()
                .clickLogoutButton();
        WebElement error = new HomePage(driver)
                .loginWithCorrectData(firstUserModel)
                .clickRequestLoanLink()
                .applyForLoan("abc", "xyz")
                .getErrorMessage();
        Assert.assertEquals(error.getText(), "An internal error has occurred and has been logged.");
    }
}
