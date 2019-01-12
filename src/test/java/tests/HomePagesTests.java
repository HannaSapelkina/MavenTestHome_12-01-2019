package tests;

import pages.EventsUnAuthPageHelper;
import pages.HomePageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class HomePagesTests extends TestBase {
    HomePageHelper homePage;
    EventsUnAuthPageHelper eventsUnAuthPage;
    @BeforeMethod
    public void initPage(){
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        eventsUnAuthPage = PageFactory.initElements(driver, EventsUnAuthPageHelper.class);
    }
    @Test
    public void openHomePageTest() {
        homePage.waitUntilPageIsLoaded();
        Assert.assertEquals("Go to Event list",homePage.getGoToEventButtonName());
    }
    @Test
    public void goToEventsTest() {
        homePage.waitUntilPageIsLoaded()
                .pressGoToEventButton();
        eventsUnAuthPage.waitUntilPageIsLoaded();
        Assert.assertEquals("Find event", eventsUnAuthPage.getHeader());

    }

}
