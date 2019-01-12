package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventsAuthPageHelper extends PageBase {
    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement menuIcon;
    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filtersButton;
    @FindBy(xpath = "//h1[@class='gorisontal-center']")
    WebElement headerText;


      public EventsAuthPageHelper(WebDriver driver) {
        super(driver);
    }

    public EventsAuthPageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsLoaded(driver, menuIcon, 20);
        waitUntilElementIsLoaded(driver, filtersButton,30);
        return this;
    }

    public String getTooltipIconMenu() {

        return menuIcon.getAttribute("mattooltip");

    }

    //public String getHeader() {
    //    return headerText.getText();
    // }

    public boolean isHeaderPageCorrect(String value) {
        return headerText.getText().equals(value);
    }

}
