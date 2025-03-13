package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HomeNavigationBarPage {
    //private WebDriver driver ;

    private Driver driver;
    By homeLink = By.xpath("//a[@href=\"/\"]");
    By productsLink =By.xpath("//a[@href=\"/products\"]");
    By cartLink =By.xpath("//a[href=\"/view_cart\"]");
    By loginSignUpLink = By.xpath("//a[@href=\"/login\"]");
    By testCasesLink = By.xpath("//a[@href=\"/test_cases\"]");
    By apiTestingLink =By.xpath("//a[@href=\"/api_list\"]");
    By videoTutorialsLink = By.xpath("//a[@href=\"https://www.youtube.com/c/AutomationExercise\"]");
    By contactUsLink = By.xpath("//a[@href=\"/contact_us\"]");

    By logoutLink = By.xpath("//a[@href=\"/logout\"]");

    By deleteAccountLink = By.xpath("//a[@href=\"/delete_account\"]");

    public HomeNavigationBarPage(Driver driver){
        this.driver=driver;
    }


    //*************************************** Assertions ******************************************************
    @Step("checkThatTheLogoutButtonIsDisplayed")
    public HomeNavigationBarPage checkThatTheLogoutButtonIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }
    @Step("checkThatTheUserIsNavigatedToHomePage")
    public HomeNavigationBarPage checkThatTheUserIsNavigatedToHomePage(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("https://www.automationexercise.com/"));
        return this;
    }
    @Step("checkThatTheSignUPLoginButtonIsDisplayed")
    public HomeNavigationBarPage checkThatTheSignUPLoginButtonIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(loginSignUpLink));
        return this;
    }



    //*************************************** Actions ******************************************************
    @Step("clickOnHomeLink")
    public HomeNavigationBarPage clickOnHomeLink(){
        driver.element().click(homeLink);
        return this;
    }

    @Step("clickOnProductsLink")
    public void clickOnProductsLink (){
        driver.element().click(productsLink);
    }
    @Step("clickOnCartLink ")
    public void clickOnCartLink (){
        driver.element().click(cartLink);
    }
    @Step("clickOnLoginSignUPLink")
    public LoginSignUpPage clickOnLoginSignUPLink (){
        driver.element().click(loginSignUpLink);
        return new LoginSignUpPage(driver);
    }

    @Step("clickOnTestCasesLink")
    public void clickOnTestCasesLink (){
        driver.element().click(testCasesLink);
    }
    @Step("clickOnApiTestingLink")
    public void clickOnApiTestingLink(){

        driver.element().click(apiTestingLink);
    }
    @Step("clickOnVideoTutorialsLink")
    public void clickOnVideoTutorialsLink(){
        driver.element().click(videoTutorialsLink);
    }

    @Step("clickOnContactUsLin")
    public ContactUsPage clickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }
   @Step("clickOnLogoutLink")
    public LoginSignUpPage clickOnLogoutLink(){
        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver);
    }

    @Step("clickOnDeleteAccountLink")
    public DeletionAccountSuccessPage clickOnDeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new DeletionAccountSuccessPage(driver);
    }






}
