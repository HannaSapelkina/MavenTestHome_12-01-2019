package tests;

import org.testng.annotations.DataProvider;
import org.apache.log4j.Logger;
import pages.EventsAuthPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MenuPageHelper;
import util.DataProviders;
import util.LogLog4j;

public class LoginPageTests extends TestBase {

    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;
    MenuPageHelper menuPage;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @BeforeMethod
    public void initPage() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        eventsAuthPage = PageFactory.initElements(driver,EventsAuthPageHelper.class);
        menuPage = PageFactory.initElements(driver,MenuPageHelper.class);
    }
    @Test (dataProviderClass = DataProviders.class, dataProvider = "loginPositive")
    public void loginPositive(String email, String password) {
        Log.info("--------Test loginPositive was started---------");
        Log.info("Parameter: email = " + email);
        Log.info("Parameter: password = " + password);
        Log.info("Test login Positive: homePage was opened");
        homePage.waitUntilPageIsLoaded()
                .pressLoginButton()
                .waitUntilPageIsLoaded();
        Log.info("Test login Positive: loginPage was opened");
        loginPage.enterValueToEmailField(email)
                .enterValueToPasswordField(password)
                .pressLoginButton();
        eventsAuthPage.waitUntilPageIsLoaded();

        Assert.assertEquals("Menu", eventsAuthPage.getTooltipIconMenu());
        Assert.assertEquals("Find event",eventsAuthPage.getHeader());

        eventsAuthPage.pressMenuIcon();
        menuPage.waitUntilPageIsLoaded()
                .pressLogOutButton();
        homePage.waitUntilPageIsLoaded();
        Assert.assertEquals(homePage.getHeader(), "Shabbat in the family circle");
    }


    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginNegative")
    public void loginNegative(String email, String password){
        Log.info("--------- Test loginNegative was started -----------");
        Log.info("Parameter - email: " + email);
        Log.info("Parameter - password: " + password);
        Log.info("loginNegative: homePage is opened");
        homePage.waitUntilPageIsLoaded()
                .pressLoginButton();
        Log.info("loginNegative: loginPage was opened");
        loginPage.waitUntilPageIsLoaded()
                .enterValueToEmailField(email)
                .enterValueToPasswordField(password)
                .pressLoginButton();
        Assert.assertEquals("Wrong authorization, login or password", loginPage.getAlertText(),
                           "alert 'Wrong authorization, login or password' wasn't given");
        Log.info("loginNegative: loginPage was opened");
        loginPage.pressCancelButton()
                 .waitUntilWindowIsClosed();
    }
}
