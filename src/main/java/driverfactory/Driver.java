package driverfactory;

import browserActions.BrowserActions;
import elementActions.ElementActions;
import listeners.webdriver.WebDriverListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import static utilities.properties.PropertiesManager.webConfig;

public class Driver {

   //private  WebDriver driver;
    public ThreadLocal<WebDriver> driver ;

    public Driver(/*String browserDriverType*/){

          // driver=chooseBrowserDriver(browserDriverType).startDriver();
    //  WebDriver undecoratedDriver = chooseBrowserDriver(browserDriverType).startDriver();

     // driver = new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,new WebDriverListeners(undecoratedDriver)).decorate(undecoratedDriver);

     // assert driver!= null;  //assertions from java btrag3 exception lo driver bnull

  String browserDriverType =webConfig.getProperty("BrowserType");
        WebDriver undecoratedDriver = chooseBrowserDriver(browserDriverType).startDriver();
        assert undecoratedDriver != null;


       driver = new ThreadLocal<>();
       driver.set(new EventFiringDecorator<>(org.openqa.selenium.WebDriver.class,
                new WebDriverListeners(undecoratedDriver))
                .decorate(undecoratedDriver));
        System.out.println("Starting the execution via " + browserDriverType + " driver");

        if (!webConfig.getProperty("BaseURL").isEmpty()){
            driver.get().navigate().to(webConfig.getProperty("BaseURL"));
        }


    }

    private DriverAbstract chooseBrowserDriver(String browserDriverType){

        switch (browserDriverType){
            case "CHROME" : {
                return new ChromeDriverFactory();
            }
            case "FIREFOX" : {
                return new FirefoxDriverFactory();
            }
            case "EDGE" : {
                return new EdgeDriverFactory();
            }
            default:{
                throw new IllegalStateException("Unexpected value:"+ driver);
            }
        }

    }

    public  WebDriver get(){
        return driver.get();
    }

    public ElementActions element(){
        return new ElementActions(driver.get());
    }

    public BrowserActions browser(){
        return new BrowserActions(driver.get());
    }


    public void QuitDriver(){
       driver.get().quit();
    }
}
