package tests;

import org.testng.annotations.Test;
import pages.HomeNavigationBarPage;
import tests.TestBase;

public class ContactUsTest extends TestBase {

    @Test
    public void UserCanFillContactUsFormSuccessfully(){


        new HomeNavigationBarPage(driver.get()).clickOnContactUsLink()
                .checkThatTheUserISNavigatedToContactUsPage()
                .fillContactUsForm("Rana","Rana@gmail.com","Test","Test")
                .checkThatTheFormIsSubmittedSuccessfully()
                .clickOnHomeButton()
                .checkThatTheUserIsNavigatedToHomePage();

       // ScreenShotManager.captureScreenshots(parallelExecutionparallelExecutionDriver.get().get().get(),"ContactUs");

    }
}
