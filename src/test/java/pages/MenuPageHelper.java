package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPageHelper extends PageBase {
    @FindBy(xpath = "//span[@class='marginLeft']")
    WebElement logOutButton;


    public MenuPageHelper(WebDriver driver) {
        super(driver);
    }
    public MenuPageHelper waitUntilPageIsLoaded(){

        waitUntilElementIsLoaded(driver,logOutButton,30);
        return this;
    }

    public MenuPageHelper pressLogOutButton() {
        logOutButton.click();
        return this;
    }
}
