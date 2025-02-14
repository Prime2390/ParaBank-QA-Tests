package DominikBernas.pages;
import DominikBernas.models.RegisterModelFaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RegisterPage {
     WebDriver driver;

    @FindBy(id = "customer.firstName")
    private WebElement firstName;
    @FindBy(id = "customer.lastName")
    private WebElement lastName;
    @FindBy(id = "customer.address.street")
    private WebElement street;
    @FindBy(id = "customer.address.city")
    private WebElement city;
    @FindBy(id = "customer.address.state")
    private WebElement state;
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;
    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;
    @FindBy(id = "customer.ssn")
    private WebElement ssn;
    @FindBy(id = "customer.username")
    private WebElement username;
    @FindBy(id = "customer.password")
    private WebElement password;
    @FindBy(id = "repeatedPassword")
    private WebElement confirmPassword;
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;


     public RegisterPage(WebDriver driver) {
         this.driver = driver;
         PageFactory.initElements(driver, this);
     }
    public RegisterPage registerWithValidData(RegisterModelFaker registerModel) {
         firstName.sendKeys(registerModel.getFirstName());
         lastName.sendKeys(registerModel.getLastName());
         street.sendKeys(registerModel.getAddress());
         city.sendKeys(registerModel.getCity());
         state.sendKeys(registerModel.getState());
         zipCode.sendKeys(registerModel.getZipCode());
         phoneNumber.sendKeys(registerModel.getPhoneNumber());
         ssn.sendKeys(registerModel.getPesel());
         username.sendKeys(registerModel.getLogin());
         password.sendKeys(registerModel.getPassword());
         confirmPassword.sendKeys(registerModel.getPassword());
         return this;
    }
    public LoginPage clickRegisterButtonWithInvalidData() {
         registerButton.click();
        return new LoginPage(driver);
    }




}
