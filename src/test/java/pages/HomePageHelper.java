package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageHelper extends PageBase{
    @FindBy(xpath = "//span[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'Create Account')]")
    WebElement createAccountButton;
    @FindBy(xpath = "//span[contains(text(),'Go to Event list')]")
    WebElement goToEventsButton;


    public HomePageHelper(WebDriver driver){

        super(driver);
    }

    public HomePageHelper waitUntilPageIsLoaded() {
        waitUntilElementIsLoaded(driver, loginButton, 40);
        waitUntilElementIsLoaded(driver, createAccountButton,40);
        waitUntilElementIsLoaded(driver, goToEventsButton,40);
        return this;
    }

    public HomePageHelper pressLoginButton (){

        loginButton.click();
        return this;
    }

    public String getGoToEventButtonName() {

        return goToEventsButton.getText();

    }

    public HomePageHelper pressGoToEventButton() {

        goToEventsButton.click();
        return this;
    }

    public HomePageHelper pressCreateAccountButton() {

        createAccountButton.click();
        return this;
    }
}
