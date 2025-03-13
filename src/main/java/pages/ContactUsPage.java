package pages;

import driverfactory.Driver;
import elementActions.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ContactUsPage {
    //WebDriver driver;
    private Driver driver ;

    By nameTextField = By.xpath("//input[@data-qa=\"name\"]");
    By emailTextField = By.xpath("//input[@data-qa=\"email\"]");
    By subjectTextField = By.xpath("//input[@data-qa=\"subject\"]");

    By messageTextField = By.id("message");

    By uploadFileButton = By.xpath("//input[@name=\"upload_file\"]");

    By submitButton = By.xpath("//input[@data-qa=\"submit-button\"]");

    By contactUsLabel= By.xpath("(//h2[@class=\"title text-center\"])[1]");

    By successMessage = By.cssSelector("div.status.alert.alert-success");

    By homeButton =By.xpath("//a[@class=\"btn btn-success\"]");

    public ContactUsPage(Driver driver){
        this.driver=driver;
    }

    //*************************************** Assertions ******************************************************

    @Step("checkThatTheUserISNavigatedToContactUsPage")
    public ContactUsPage checkThatTheUserISNavigatedToContactUsPage(){
        Assert.assertEquals(driver.browser().getCurrentUrl(),"https://www.automationexercise.com/contact_us");
        Assert.assertTrue(driver.element().isDisplayed(contactUsLabel));
        Assert.assertEquals(driver.element().getTxtOf(contactUsLabel),"CONTACT US");
        return this;
    }
    @Step("checkThatTheFormIsSubmittedSuccessfully")
    public ContactUsPage checkThatTheFormIsSubmittedSuccessfully(){
        Assert.assertTrue(driver.element().isDisplayed(successMessage));
        Assert.assertEquals(driver.element().getTxtOf(successMessage),"Success! Your details have been submitted successfully.");
         return this;
    }


    //*************************************** Actions ******************************************************
    @Step("The user fills NameTextField")
    public ContactUsPage fillNameTextField(String name){
        driver.element().fillTextField(nameTextField,name);
        return this;
    }
    @Step("The user fills EmailTextField")
    public ContactUsPage fillEmailTextField(String email){
        driver.element().fillTextField(emailTextField,email);
        return this;
    }
    @Step("The user fills SubjectTextField")
    public ContactUsPage fillSubjectTextField(String subject){
        driver.element().fillTextField(subjectTextField,subject);
        return this;
    }
    @Step("The user fills MessageTextField")
    public ContactUsPage fillMessageTextField(String message){
        driver.element().fillTextField(messageTextField,message);
        return this;
    }

    @Step("clickOnUploadFileButton")
    public ContactUsPage clickOnUploadFileButton(){
        driver.element().click(uploadFileButton);
        return this;
    }

    @Step("clickOnSubmitButton")
    public ContactUsPage clickOnSubmitButton(){
        driver.element().click(submitButton);
        driver.get().switchTo().alert().accept();
        return this;
    }

    @Step("clickOnHomeButton")
    public HomeNavigationBarPage clickOnHomeButton(){
        driver.element().click(homeButton);
        return new HomeNavigationBarPage(driver);
    }

    @Step("fillContactUsForm")
    public ContactUsPage fillContactUsForm(String name , String email , String subject , String message){
        fillNameTextField(name);
        fillEmailTextField(email);
        fillSubjectTextField(subject);
        fillMessageTextField(message);
        clickOnSubmitButton();
        return this;
    }

}
