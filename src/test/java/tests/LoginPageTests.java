package tests;

import pages.EventsAuthPageHelper;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    HomePageHelper homePage;
    LoginPageHelper loginPage;
    EventsAuthPageHelper eventsAuthPage;

    @BeforeMethod
    public void initPage() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        eventsAuthPage = PageFactory.initElements(driver,EventsAuthPageHelper.class);
    }
    @Test
    public void loginPositive() {

        homePage.waitUntilPageIsLoaded()
                .pressLoginButton();
        loginPage.waitUntilPageIsLoaded()
                .enterValueToEmailField("mishUser1@gmail.com")
                .enterValueToPasswordField("example")
                .pressLoginButton();
        eventsAuthPage.waitUntilPageIsLoaded();
        Assert.assertEquals("Menu",eventsAuthPage.getTooltipIconMenu());
        Assert.assertTrue(eventsAuthPage.isHeaderPageCorrect("Find event"));
    }

    @Test
    public void loginNegative (){
        homePage.waitUntilPageIsLoaded()
                .pressLoginButton();
        loginPage.waitUntilPageIsLoaded()
                .enterValueToEmailField("mishUser15456@gmail.com")
                .enterValueToPasswordField("example")
                .pressLoginButton();
        Assert.assertEquals(loginPage.getAlertText(),"Wrong authorization, login or password");
        Assert.assertTrue(loginPage.isAlertTextCorrect("Wrong authorization, login or password"));
    }
}
