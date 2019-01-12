package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageHelper extends PageBase {
    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement menuIcon;
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//h1[@class='classCentr']")
    WebElement header;

    public ProfilePageHelper(WebDriver driver) {
        super(driver);
    }

    public ProfilePageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsLoaded(driver,cancelButton,40);
        waitUntilElementIsLoaded(driver,menuIcon,40);
        waitUntilElementIsLoaded(driver,header,40);
        return this;
    }

    public ProfilePageHelper  pressMenuIcon(){

        menuIcon.click();
        return this;
    }

    public String getHeader() {
        return header.getText();
    }
}
