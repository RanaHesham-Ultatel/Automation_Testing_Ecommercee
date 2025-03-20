package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class RegistrationSuccessPage {

    //private WebDriver driver;

    private Driver driver;

    private WebDriverWait wait;

    private FluentWait fluentWait;

    By accountCreatedMsg = By.xpath("//h2[@data-qa=\"account-created\"]");

    public RegistrationSuccessPage(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver.get(), Duration.ofSeconds(10));

       /* fluentWait = new FluentWait<>(this.driver.get()).withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);*/

    }

    //*************************************** Assertions ******************************************************
    @Step("userCreateAccountSuccessfully")
    public RegistrationSuccessPage userCreateAccountSuccessfully() {

        //fluentWait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMsg));

        //wait.until(ExpectedConditions.urlToBe("https://www.automationexercise.com/account_created"));
        //   wait.until(ExpectedConditions.visibilityOf(driver.findElement(accountCreatedMsg)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMsg));
        Assert.assertEquals(driver.browser().getCurrentUrl(), "https://www.automationexercise.com/account_created");
        Assert.assertTrue(driver.element().isDisplayed(accountCreatedMsg));
        Assert.assertEquals(driver.element().getTxtOf(accountCreatedMsg), "ACCOUNT CREATED!");
        return this;
    }
    //*************************************** Actions ******************************************************
}
