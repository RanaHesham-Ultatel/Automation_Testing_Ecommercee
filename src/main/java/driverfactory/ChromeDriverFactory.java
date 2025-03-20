package driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static utilities.properties.PropertiesManager.webConfig;

public class ChromeDriverFactory extends DriverAbstract{


    @Override
    public WebDriver startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        if (webConfig.getProperty("HeadlessMode").equalsIgnoreCase("true")){
            options.addArguments("--headless");
        }


        driver=  new ChromeDriver(options);
        return driver;
    }
}
