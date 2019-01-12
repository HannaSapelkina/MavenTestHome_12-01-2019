package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[contains(text(),'Log in')]")
    WebElement logInButton;
    @FindBy(xpath = "//div[@class='alert alert-danger ng-star-inserted']")
    WebElement alertText;

    public LoginPageHelper (WebDriver driver){

        super(driver);
    }

    public LoginPageHelper waitUntilPageIsLoaded() {

        waitUntilElementIsLoaded(driver, cancelButton,20);
        return this;
    }

    public LoginPageHelper enterValueToEmailField(String value){

        setValueToField(emailField,value);
        return this;
    }

    public LoginPageHelper enterValueToPasswordField(String value){

       setValueToField(passwordField,value);
        return this;
    }

    public LoginPageHelper pressLoginButton (){

        waitUntilElementIsLoaded(driver, logInButton, 45);
        logInButton.click();
        return this;
    }


    public String getAlertText() {
        waitUntilElementIsLoaded(driver, alertText,20);
        return alertText.getText();
    }

    public boolean isAlertTextCorrect(String value) {
        waitUntilElementIsLoaded(driver, alertText, 45);
        return alertText.getText().equals(value);
    }
}
