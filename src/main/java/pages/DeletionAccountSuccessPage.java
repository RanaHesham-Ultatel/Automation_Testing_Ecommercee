package pages;

import driverfactory.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DeletionAccountSuccessPage{

    //WebDriver driver;

    Driver driver;

    By accountDeletedLabel = By.xpath("//h2[@data-qa=\"account-deleted\"]");

    By continueButton = By.xpath("//a[@data-qa=\"continue-button\"]");

    public  DeletionAccountSuccessPage (Driver driver){
        this.driver=driver;
    }


    //*************************************** Assertions ******************************************************


    public DeletionAccountSuccessPage checkThatTheAccountIsDeletedSuccessfully(){
        Assert.assertEquals(driver.browser().getCurrentUrl(),"https://www.automationexercise.com/delete_account");
        Assert.assertTrue(driver.element().isDisplayed(accountDeletedLabel));
        Assert.assertEquals(driver.element().getTxtOf(accountDeletedLabel),"ACCOUNT DELETED!");
       return this;

    }

    //*************************************** Actions ******************************************************

    public HomeNavigationBarPage clickOnContinueButton(){
        driver.element().click(continueButton);
        return new HomeNavigationBarPage(driver);
    }

}
