package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginSignUpPage {

    //private WebDriver driver;

    Driver driver;

    By loginEmail = By.xpath("//input[@data-qa=\"login-email\"]");
    By loginPassword = By.xpath("//input[@data-qa=\"login-password\"]");
    By loginButton = By.xpath("//button[@data-qa=\"login-button\"]");

    By signUpName = By.xpath("//input[@data-qa=\"signup-name\"]");
    By signUpEmail = By.xpath("//input[@data-qa=\"signup-email\"]");
    By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    By signUpFormTitle = By.xpath("(//h2)[3]");

    public LoginSignUpPage(Driver driver) {
        this.driver = driver;
    }

    //*************************************** Assertions ******************************************************

    @Step("checkThatUserIsNavigatedToLoginSignUpPage")
    public LoginSignUpPage checkThatUserIsNavigatedToLoginSignUpPage() {
        Assert.assertTrue(driver.browser().getCurrentUrl().contains("/login"));
        Assert.assertEquals(driver.element().getTxtOf(signUpFormTitle), "New User Signup!");
        return this;
    }

    //*************************************** Actions ******************************************************
    @Step("fillInLoginEmail")
    public LoginSignUpPage fillInLoginEmail(String email) {

        driver.element().fillTextField(loginEmail, email);
        return this;
    }

    @Step("fillInLoginPassword")
    public LoginSignUpPage fillInLoginPassword(String password) {
        driver.element().fillTextField(loginPassword, password);
        return this;
    }

    @Step("clickOnLoginButton")
    public HomeNavigationBarPage clickOnLoginButton() {
        driver.element().click(loginButton);
        return new HomeNavigationBarPage(driver);
    }

    @Step("fillInSignUpName")
    public LoginSignUpPage fillInSignUpName(String name) {
        driver.element().fillTextField(signUpName, name);
        return this;
    }

    @Step("fillInSignUpEmai")
    public LoginSignUpPage fillInSignUpEmail(String email) {
        driver.element().fillTextField(signUpEmail, email);
        return this;
    }

    @Step("clickOnSignUpButton")
    public CreationAccountPage clickOnSignUpButton() {
        driver.element().click(signUpButton);
        return new CreationAccountPage(driver);
    }


}
