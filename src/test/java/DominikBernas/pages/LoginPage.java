package DominikBernas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(className = "title")
    public WebElement title;

    @FindBy(linkText = "Open New Account")
    private WebElement openNewAccountLink;

    @FindBy(linkText = "Accounts Overview")
    private WebElement accountsOverviewLink;

    @FindBy(linkText = "Transfer Funds")
    private WebElement transferFundsLink;

    @FindBy(linkText = "Bill Pay")
    private WebElement billPayLink;

    @FindBy(linkText = "Find Transactions")
    private WebElement findTransactionsLink;

    @FindBy(linkText = "Update Contact Info")
    private WebElement updateContactInfoLink;

    @FindBy(linkText = "Request Loan")
    private WebElement requestLoanLink;

    @FindBy(xpath = "//a[text()='Log Out']")
    public WebElement logoutButton;

    @FindBy(xpath = "//h1[@class='title' and contains(text(), 'Accounts Overview')]")
    private WebElement accountsOverviewHeader;

    @FindBy(xpath = "//img[@title='ParaBank']")
    private WebElement paraBank;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage clickLogoutButton() {
        logoutButton.click();
        return new HomePage(driver);
    }

    public RequestLoanPage clickRequestLoanLink() {
        requestLoanLink.click();
        return new RequestLoanPage(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getAccountsOverviewHeader() {
        return accountsOverviewHeader;
    }

    public WebElement getParaBank() {
        return paraBank;
    }
}
