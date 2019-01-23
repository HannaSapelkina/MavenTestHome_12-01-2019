package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

public class EventsAuthPageHelper extends PageBase {
    @FindBy(xpath = "//mat-icon[@class='but mat-icon material-icons']")
    WebElement menuIcon;
    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filtersButton;
    @FindBy(xpath = "//h1[@class='gorisontal-center']")
    WebElement headerText;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());



    public EventsAuthPageHelper(WebDriver driver) {
        super(driver);
    }

    public EventsAuthPageHelper waitUntilPageIsLoaded() {
        Log.info("EventsAuthPageHelper: -------------- Wait until EventsAuthPage is loaded -----------");
        Log.info("EventsAuthPageHelper: menuIcon was loaded");
        waitUntilElementIsLoaded(driver, menuIcon, 20);
        Log.info("EventsAuthPageHelper: filtersButton was loaded");
        waitUntilElementIsLoaded(driver, filtersButton,30);
        return this;
    }

    public String getTooltipIconMenu() {

        return menuIcon.getAttribute("mattooltip");

    }

    public String getHeader() {
       return headerText.getText();
     }

    public boolean isHeaderPageCorrect(String value) {
        return headerText.getText().equals(value);
    }
    public EventsAuthPageHelper  pressMenuIcon(){
        Log.info("EventsAuthPageHelper: -------------- pressMenuIcon ()  ---");
        Log.info("EventsAuthPageHelper: click on MenuIcon");
        menuIcon.click();
        return this;
    }

}
