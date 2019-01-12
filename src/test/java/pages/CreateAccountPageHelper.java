package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPageHelper extends PageBase {
    @FindBy(xpath = "//span[contains(text(),'Cancel')]")
    WebElement cancelButton;
    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@formcontrolname='passwordRep']")
    WebElement passwordRepField;
    @FindBy(xpath = "//span[contains(text(),'Registration')]")
    WebElement registrationButton;

    public CreateAccountPageHelper(WebDriver driver) {
        super(driver);
    }

    public CreateAccountPageHelper waitUntilPageIsLoaded(){

        waitUntilElementIsLoaded(driver,cancelButton,40);
        return this;
    }


    public CreateAccountPageHelper enterValueToFieldEmail(String value) {

        setValueToField(emailField,value);
        return this;
    }

    public CreateAccountPageHelper enterValueToFieldPassword(String value) {

        setValueToField(passwordField,value);
        return this;
    }

    public CreateAccountPageHelper enterValueToFieldPasswordRep(String value) {

        setValueToField(passwordRepField,value);
        return this;
    }

    public CreateAccountPageHelper pressRegistrationButton() {

        waitUntilElementIsLoaded(driver, registrationButton,20);
        registrationButton.click();
        return this;
    }


    public CreateAccountPageHelper enterValueToFieldEmailRandom() {
        String email = getSaltString() + "@gmail.com";
        enterValueToFieldEmail(email);
        return this;
    }

}
