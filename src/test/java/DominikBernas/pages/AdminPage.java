package DominikBernas.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdminPage {
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@value='CLEAN']")
    private WebElement cleanDatabaseButton;

    public void resetDatabase() {
        driver.get("https://parabank.parasoft.com/parabank/admin.htm");
        cleanDatabaseButton.click();
    }
}
