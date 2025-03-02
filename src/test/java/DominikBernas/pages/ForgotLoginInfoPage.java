package DominikBernas.pages;

import DominikBernas.models.FirstUserModel;
import DominikBernas.models.RegisterModelFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ForgotLoginInfoPage {
    WebDriver driver;
    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "address.street")
    private WebElement addressInput;

    @FindBy(id = "address.city")
    private WebElement cityInput;

    @FindBy(id = "address.state")
    private WebElement stateInput;

    @FindBy(id = "address.zipCode")
    private WebElement zipCodeInput;


    @FindBy(id = "ssn")
    private WebElement ssnInput;

    @FindBy(xpath = "//input[@type='submit' and @class='button' and @value='Find My Login Info']")
    private WebElement findMyLoginInfoButton;

    @FindBy(xpath = "//p[2]")
    private WebElement Username;

    @FindBy(className = "error")
    private WebElement errorMessage;

    @FindBy(xpath = "//span[contains(@id, 'errors')]")
    private List<WebElement> errorMessages;


    public ForgotLoginInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ForgotLoginInfoPage enterCastomerLookupWithValidData(FirstUserModel firstUserModel) {
        firstNameInput.sendKeys(firstUserModel.getFirstName());
        lastNameInput.sendKeys(firstUserModel.getLastName());
        addressInput.sendKeys(firstUserModel.getAddress());
        cityInput.sendKeys(firstUserModel.getCity());
        stateInput.sendKeys(firstUserModel.getState());
        zipCodeInput.sendKeys(firstUserModel.getZip());
        ssnInput.sendKeys(firstUserModel.getSsn());
        findMyLoginInfoButton.click();
        return this;
    }

    public ForgotLoginInfoPage enterCastomerLookupWithInvalidData(RegisterModelFaker firstUserModel) {
        firstNameInput.sendKeys(firstUserModel.getFirstName());
        lastNameInput.sendKeys(firstUserModel.getLastName());
        addressInput.sendKeys(firstUserModel.getAddress());
        cityInput.sendKeys(firstUserModel.getCity());
        stateInput.sendKeys(firstUserModel.getState());
        zipCodeInput.sendKeys(firstUserModel.getZipCode());
        ssnInput.sendKeys(firstUserModel.getPesel());
        findMyLoginInfoButton.click();
        return this;
    }

    public ForgotLoginInfoPage ForgotLoginButton() {
        findMyLoginInfoButton.click();
        return this;
    }

    public WebElement getUsername() {
        return Username;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public List<String> getErrorMessages() {
        return errorMessages
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

}
