package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DeletionAccountSuccessPage {

    //WebDriver driver;

    Driver driver;

    By accountDeletedLabel = By.xpath("//h2[@data-qa=\"account-deleted\"]");

    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public DeletionAccountSuccessPage(Driver driver) {
        this.driver = driver;
    }


    //*************************************** Assertions ******************************************************

    @Step("checkThatTheAccountIsDeletedSuccessfully")
    public DeletionAccountSuccessPage checkThatTheAccountIsDeletedSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentUrl(), "https://www.automationexercise.com/delete_account");
        Assert.assertTrue(driver.element().isDisplayed(accountDeletedLabel));
        Assert.assertEquals(driver.element().getTxtOf(accountDeletedLabel), "ACCOUNT DELETED!");
        return this;

    }

    //*************************************** Actions ******************************************************
    @Step("clickOnContinueButton")
    public HomeNavigationBarPage clickOnContinueButton() {
        driver.element().click(continueButton);
        return new HomeNavigationBarPage(driver);
    }

}
