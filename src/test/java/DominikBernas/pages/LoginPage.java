package DominikBernas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    @FindBy(className = "title")
    public WebElement title;
    @FindBy(xpath = "//a[text()='Log Out']")
    public WebElement logoutButton;
    @FindBy(xpath = "//h1[@class='title' and contains(text(), 'Accounts Overview')]")
    private WebElement accountsOverviewHeader;




    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public HomePage clickLogoutButton() {
        logoutButton.click();
        return new HomePage(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getAccountsOverviewHeader() {
        return accountsOverviewHeader;
    }
}
