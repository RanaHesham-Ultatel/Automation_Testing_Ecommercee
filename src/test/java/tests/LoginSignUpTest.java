package tests;

import org.testng.annotations.Test;
import pages.*;
import tests.TestBase;


public class LoginSignUpTest extends TestBase {

    String email = "Rana35@gmail.com";


    @Test(priority = 1)
    public void userCanRegisterSuccessfully (){


        new HomeNavigationBarPage(driver.get()).clickOnLoginSignUPLink()
                .checkThatUserIsNavigatedToLoginSignUpPage()
                .fillInSignUpName("Rana")
                .fillInSignUpEmail(email)
                .clickOnSignUpButton()
                .checkthatTheUserIsNavigatedToCreationAccountPageSuccessfully();


    }

    @Test(priority = 2 , dependsOnMethods = "userCanRegisterSuccessfully")
    public void userCreateAccountSuccessfully(){


        new CreationAccountPage(driver.get()).fillInCreationAccountForm()
                .userCreateAccountSuccessfully();
        driver.get().get().manage().deleteAllCookies();
        new HomeNavigationBarPage(driver.get()).checkThatTheUserIsNavigatedToHomePage();



    }

   @Test (priority = 3 ,dependsOnMethods = {"userCanRegisterSuccessfully","userCreateAccountSuccessfully"})
    public void userCanLoginSuccessfully (){


       new HomeNavigationBarPage(driver.get()).clickOnLoginSignUPLink()
               .fillInLoginEmail(email)
               .fillInLoginPassword("123456")
               .clickOnLoginButton()
               .checkThatTheUserIsNavigatedToHomePage()
               .checkThatTheLogoutButtonIsDisplayed();


    }

    @Test (priority = 3 ,dependsOnMethods = "userCanLoginSuccessfully")
    public void userCanLogoutSuccessfully (){

        new HomeNavigationBarPage(driver.get()).clickOnLogoutLink()
                .checkThatUserIsNavigatedToLoginSignUpPage();



    }

    @Test (priority = 4 ,dependsOnMethods = "userCanLogoutSuccessfully")
    public void userCanDeleteAccountSuccessfully (){

        new HomeNavigationBarPage(driver.get()).clickOnLoginSignUPLink()
                .fillInLoginEmail(email)
                .fillInLoginPassword("123456")
                .clickOnLoginButton()
                .clickOnDeleteAccountLink()
                .checkThatTheAccountIsDeletedSuccessfully()
                .clickOnContinueButton()
                .checkThatTheUserIsNavigatedToHomePage()
                .checkThatTheSignUPLoginButtonIsDisplayed();


    }
}
