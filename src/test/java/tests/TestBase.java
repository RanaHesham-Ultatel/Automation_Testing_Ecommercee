package tests;

import driverfactory.Driver;
import driverfactory.DriverAbstract;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.ScreenShotManager;

import java.time.Duration;

public class TestBase {

  //  WebDriver driver ;

  //  Driver driver;

    ThreadLocal <Driver> driver ;
// set ,//get

    @BeforeClass
    @Parameters(value = {"browserName"})
    public void setUp (@Optional("CHROME") String browserName) {

      driver = new ThreadLocal<>() ;
      driver.set(new Driver(browserName));
      driver.get().browser().navigateToUrl("https://www.automationexercise.com/");


      //  driver = new Driver(browserName);
     //   driver.browser().navigateToUrl("https://www.automationexercise.com/");


       // driver.browser().scrollToBottom();
     /*  driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.element()
                .hoverOnItem(By.xpath("(//*[@class=\"product-overlay\"])[1]"))
                .click(By.xpath("(//*[@class=\"btn btn-default add-to-cart\"])[1]"));*/

       // parallelExecutionDriver = new ThreadLocal<>();
      //  parallelExecutionDriver.set(new Driver(browserName));
     //   parallelExecutionDriver.get().browser().navigateToUrl("https://www.automationexercise.com/");




    }

    /*@AfterMethod
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Test Failed");
            System.out.println("Taking screenshot ....");
            ScreenShotManager.captureScreenshots(driver.get(),result.getName());
        }

    }*/



    @AfterClass
    public void tearDown (){
        //driver.manage().deleteAllCookies();
        //driver.quit();
        driver.get().QuitDriver();

    }
}
