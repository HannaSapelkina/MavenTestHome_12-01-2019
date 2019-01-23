package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;


public class HomePageHelper extends PageBase{
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement createAccountButton;
    @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
    WebElement goToEventsButton;
    @FindBy(xpath =  "//h1[@class='mat-display-3']")
    WebElement headerText;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public HomePageHelper(WebDriver driver){

        super(driver);
    }

    public HomePageHelper waitUntilPageIsLoaded() {
        Log.info("HomePageHelper: wait until page is loaded");
        Log.info("HomePageHelper: wait until loginButton is loaded");
        waitUntilElementIsLoaded(driver, loginButton, 45);
        Log.info("HomePageHelper: wait until createAccountButton is loaded");
        waitUntilElementIsLoaded(driver, createAccountButton,40);
        Log.info("HomePageHelper: wait until goToEventButton is loaded");
        waitUntilElementIsLoaded(driver, goToEventsButton,40);
        return this;
    }

    public HomePageHelper pressLoginButton (){
        Log.info("HomePageHelper: ------------- Press Login button -------------");
        Log.info("HomePageHelper: Login button was clicked");
        loginButton.click();
        return this;
    }

    public String getGoToEventButtonName() {
        return goToEventsButton.getText();

    }

    public HomePageHelper pressGoToEventButton() {

        Log.info("HomePageHelper: -------------- pressGoToEventsButton () --------------");
        Log.info("HomePageHelper: click on GoToEvents button");
        goToEventsButton.click();
        return this;
    }

    public HomePageHelper pressCreateAccountButton() {
        Log.info("HomePageHelper: -------------- pressCreateAccountButton () --------------");
        Log.info("HomePageHelper: click on CreateAccount button");
        createAccountButton.click();
        return this;
    }
    public String getHeader() {
            return headerText.getText();
         }
}
