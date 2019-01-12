package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EventsUnAuthPageHelper extends PageBase{
    @FindBy(xpath = "//span[contains(text(),'Filters')]")
    WebElement filtersButton;
    @FindBy(xpath = "//h1[@class='gorisontal-center']")
    WebElement headerText;

    public EventsUnAuthPageHelper(WebDriver driver) {
        super(driver);
    }

    public EventsUnAuthPageHelper waitUntilPageIsLoaded() {
       waitUntilElementIsLoaded(driver,filtersButton, 45 );
       return this;
    }

    public String getHeader() {

        return headerText.getText();
    }
}
