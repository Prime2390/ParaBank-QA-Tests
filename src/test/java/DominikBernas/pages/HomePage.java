package DominikBernas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"loginPanel\"]/p/a[text()='Register']")
    WebElement registerButton;





    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public RegisterPage clickRegisterButton(){
        registerButton.click();
        return new RegisterPage(driver);
    }
}
