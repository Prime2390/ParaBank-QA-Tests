package DominikBernas.pages;

import DominikBernas.utils.SeleniumWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage {
    private WebDriver driver;
    @FindBy(id = "amount")
    private WebElement amountInput;
    @FindBy(id = "downPayment")
    private WebElement downPaymentInput;
    @FindBy(css = ".button[value ='Apply Now']")
    private WebElement applyNowButton;
    @FindBy(xpath = "//div[@id = \"loanRequestApproved\"]/p[1]")
    private WebElement requestLoanApproved;
    @FindBy(xpath = "//div[@id='requestLoanError']//p[@class='error']")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@id='loanRequestDenied']//p[@class='error']")
    private WebElement errorTitle;

    public RequestLoanPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public RequestLoanPage applyForLoan(String loan, String Payment) {
        new SeleniumWaiter().waitForClickable(amountInput, driver);
        amountInput.sendKeys(loan);
        downPaymentInput.sendKeys(Payment);
        applyNowButton.click();
        return this;
    }

    public String getRequestLoanApproved() {
        new SeleniumWaiter().waitForVisible(requestLoanApproved, driver);
        return requestLoanApproved.getText();
    }

    public WebElement getErrorMessage() {
        new SeleniumWaiter().waitForVisible(errorMessage, driver);
        return errorMessage;
    }

    public WebElement getErrorTitle() {
        new SeleniumWaiter().waitForVisible(errorTitle, driver);
        return errorTitle;
    }
}
