package tests;

import org.apache.log4j.Logger;
import pages.EventsUnAuthPageHelper;
import pages.HomePageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.LogLog4j;


public class HomePagesTests extends TestBase {
    HomePageHelper homePage;
    EventsUnAuthPageHelper eventsUnAuthPage;

    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        eventsUnAuthPage = PageFactory.initElements(driver, EventsUnAuthPageHelper.class);
    }
    @Test
    public void openHomePageTest() {
        Log.info("----------- Test open HomePage was started ------------");
        Log.info("Test open HomePage: wait until homePage is loaded");
        homePage.waitUntilPageIsLoaded();
        Log.info("Test open HomePage: get name of GoToEventButton");
        String goToButtonName = homePage.getGoToEventButtonName();
        Log.info("Test open HomePage: Assert: verify that name"
                + "'Go to Event list' is equal to real name"
                + goToButtonName+ "'");
        Assert.assertEquals("Go to Event list",goToButtonName);
    }
    @Test
    public void goToEventsTest() {
        Log.info("----------- Test goToEvents was started ------------");
        Log.info("Test goToEvents: wait until homePage is loaded");
        homePage.waitUntilPageIsLoaded()
                .pressGoToEventButton();
        Log.info("Test goToEvents: wait until eventsUnAuthPage is loaded");
        eventsUnAuthPage.waitUntilPageIsLoaded();
        Log.info("Test open goToEvents: get name of Find event Button");
        String findEventButton = eventsUnAuthPage.getHeader();
        Log.info("Test open goToEvents: Assert: verify that name"
                + "'Find event' is equal to real name"
                + findEventButton+ "'");
        Assert.assertEquals("Find event", findEventButton);

    }

}
