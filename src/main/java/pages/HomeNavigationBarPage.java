package pages;

import driverfactory.Driver;
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
    public HomeNavigationBarPage checkThatTheLogoutButtonIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(logoutLink));
        return this;
    }
    public HomeNavigationBarPage checkThatTheUserIsNavigatedToHomePage(){
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("https://www.automationexercise.com/"));
        return this;
    }

    public HomeNavigationBarPage checkThatTheSignUPLoginButtonIsDisplayed(){
        Assert.assertTrue(driver.element().isDisplayed(loginSignUpLink));
        return this;
    }



    //*************************************** Actions ******************************************************

    public HomeNavigationBarPage clickOnHomeLink(){
        driver.element().click(homeLink);
        return this;
    }


    public void clickOnProductsLink (){
        driver.element().click(productsLink);
    }

    public void clickOnCartLink (){
        driver.element().click(cartLink);
    }

    public LoginSignUpPage clickOnLoginSignUPLink (){
        driver.element().click(loginSignUpLink);
        return new LoginSignUpPage(driver);
    }


    public void clickOnTestCasesLink (){
        driver.element().click(testCasesLink);
    }

    public void clickOnApiTestingLink(){

        driver.element().click(apiTestingLink);
    }

    public void clickOnVideoTutorialsLink(){
        driver.element().click(videoTutorialsLink);
    }

    public ContactUsPage clickOnContactUsLink(){
        driver.element().click(contactUsLink);
        return new ContactUsPage(driver);
    }

    public LoginSignUpPage clickOnLogoutLink(){
        driver.element().click(logoutLink);
        return new LoginSignUpPage(driver);
    }

    public DeletionAccountSuccessPage clickOnDeleteAccountLink(){
        driver.element().click(deleteAccountLink);
        return new DeletionAccountSuccessPage(driver);
    }






}
