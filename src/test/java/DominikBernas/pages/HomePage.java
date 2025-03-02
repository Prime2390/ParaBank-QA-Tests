package DominikBernas.pages;

import DominikBernas.models.FirstUserModel;
import DominikBernas.models.RegisterModelFaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p/a[text()='Register']")
    WebElement registerButton;

    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit' and @value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(@href, 'lookup.htm')]")
    private WebElement forgotLoginButton;
    @FindBy(className = "error")
    private WebElement errorMessage;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return new RegisterPage(driver);
    }

    public LoginPage loginWithCorrectData(FirstUserModel firstUserModel) {
        usernameField.sendKeys(firstUserModel.getUsername());
        passwordField.sendKeys(firstUserModel.getPassword());
        loginButton.click();
        return new LoginPage(driver);
    }

    public HomePage loginWithIncorrectData(RegisterModelFaker registerModelFaker) {
        usernameField.sendKeys(registerModelFaker.getLogin());
        passwordField.sendKeys(registerModelFaker.getPassword());
        loginButton.click();
        return new HomePage(driver);
    }

    public HomePage clickLoginButton() {
        loginButton.click();
        return new HomePage(driver);
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public ForgotLoginInfoPage forgotLoginInfo() {
        forgotLoginButton.click();
        return new ForgotLoginInfoPage(driver);
    }
}
