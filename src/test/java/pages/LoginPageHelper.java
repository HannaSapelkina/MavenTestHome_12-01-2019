package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.LogLog4j;

public class LoginPageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//span[contains(text(),'Log in')]")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='alert alert-danger ng-star-inserted']")
    WebElement alertText;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    public LoginPageHelper (WebDriver driver){

        super(driver);
    }

    public LoginPageHelper waitUntilPageIsLoaded() {
        Log.info("LoginPageHelper: -------------- Wait until loginPage is loaded -----------");
        Log.info("LoginPageHelper: Cancel button was loaded");
        waitUntilElementIsLoaded(driver, cancelButton,20);
        return this;
    }

    public LoginPageHelper enterValueToEmailField(String value){
        Log.info("LoginPageHelper: -------------- Enter value email --------------");
        Log.info("LoginPageHelper: was entered email: " + value);
        setValueToField(emailField,value);
        return this;
    }

    public LoginPageHelper enterValueToPasswordField(String value){
        Log.info("LoginPageHelper: -------------- Enter value password --------------");
        Log.info("LoginPageHelper: was entered password: " + value);

        setValueToField(passwordField,value);
        return this;
    }

    public LoginPageHelper pressLoginButton (){
        Log.info("LoginPageHelper: -------------- pressLoginButton ()  ---");
        Log.info("LoginPageHelper: wait until Login button is loaded");
        waitUntilElementIsLoaded(driver, loginButton, 20);
        Log.info("LoginPageHelper: click on Login button");
        loginButton.click();
        return this;
    }

    public LoginPageHelper pressCancelButton (){
        Log.info("LoginPageHelper: -------------- pressCancelButton () --------------");
        Log.info("LoginPageHelper: wait until Cancel button is loaded");
        waitUntilElementIsLoaded(driver, cancelButton, 45);
        Log.info("LoginPageHelper: click on Cancel button");
        cancelButton.click();
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
    public LoginPageHelper waitUntilWindowIsClosed(){
        Log.info("LoginPageHelper: ------------- waitUntilWindowIsClosed() --------------");
        Log.info("LoginPageHelper: wait until Cancel button is absent");
        waitUntilElementIsAbsent(driver, cancelButton,30);
        return this;
    }
}
