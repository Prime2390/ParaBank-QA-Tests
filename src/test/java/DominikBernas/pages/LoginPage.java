package DominikBernas.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
@Getter
public class LoginPage {
    WebDriver driver;
    @Getter
    @FindBy(className = "title")
    public WebElement title;
    @FindBy(xpath = "//a[text()='Log Out']")
    public WebElement logoutButton;




    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public HomePage clickLogoutButton() {
        logoutButton.click();
        return new HomePage(driver);
    }
}
