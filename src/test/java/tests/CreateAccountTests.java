package tests;

import pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    private HomePageHelper homePage;
    private CreateAccountPageHelper accountCreatePage;
    private MenuPageHelper menuPage;
    private ProfilePageHelper profilePage;
    private LoginPageHelper loginPage;

    @BeforeMethod
    public void initPage() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        accountCreatePage = PageFactory.initElements(driver, CreateAccountPageHelper.class);
        menuPage = PageFactory.initElements(driver, MenuPageHelper.class);
        profilePage = PageFactory.initElements(driver, ProfilePageHelper.class);
        loginPage = PageFactory.initElements(driver,LoginPageHelper.class);
        homePage.waitUntilPageIsLoaded();
    }

    @Test
    public void CreateNewAccountTest(){
        homePage.pressCreateAccountButton();
        accountCreatePage.waitUntilPageIsLoaded()
                .enterValueToFieldEmailRandom()
                .enterValueToFieldPassword("example")
                .enterValueToFieldPasswordRep("example")
                .pressRegistrationButton();
        profilePage.waitUntilPageIsLoaded();
        Assert.assertEquals(profilePage.getHeader(),"Registration");

        profilePage.pressMenuIcon();
        menuPage.waitUntilPageIsLoaded()
                .pressLogOutButton();
        homePage.waitUntilPageIsLoaded();
        Assert.assertEquals("Go to Event list",homePage.getGoToEventButtonName());
    }

    @Test
    public void CreateNewAccountAndLoginTest()  {
        String email = PageBase.getSaltString() + "@gmail.com";
        homePage.pressCreateAccountButton();
        accountCreatePage.waitUntilPageIsLoaded()
                .enterValueToFieldEmail(email)
                .enterValueToFieldPassword("example")
                .enterValueToFieldPasswordRep("example")
                .pressRegistrationButton();
        profilePage.waitUntilPageIsLoaded();
        Assert.assertEquals(profilePage.getHeader(), "Registration");

        profilePage.pressMenuIcon();
        menuPage.waitUntilPageIsLoaded()
                .pressLogOutButton();
        homePage.waitUntilPageIsLoaded();
        Assert.assertEquals("Go to Event list",homePage.getGoToEventButtonName());


        //----------Login created user----------


        homePage.pressLoginButton();
        loginPage.waitUntilPageIsLoaded()
                .enterValueToEmailField(email)
                .enterValueToPasswordField("example")
                .pressLoginButton();
        profilePage.waitUntilPageIsLoaded();
        Assert.assertEquals(profilePage.getHeader(), "Registration");
    }


}
