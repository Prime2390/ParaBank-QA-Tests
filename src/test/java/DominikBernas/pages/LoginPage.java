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




    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
