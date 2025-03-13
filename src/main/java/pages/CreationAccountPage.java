package pages;

import driverfactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreationAccountPage {

   //private WebDriver driver;
    private Driver driver;

    By maleRadioButton = By.id("id_gender1");
    By femaleRadioButton = By.id("id_gender2");

    By nameTextField = By.id("name");
    By emailTextField = By.id("email");
    By passwordTextField = By.id("password");

    By daysDropDown = By.id("days");
    By monthsDropDown = By.id("months");
    By yearsDropDown = By.id("years");
    By newSletterCheckBox = By.id("newsletter");
    By specialOffersCheckBox = By.id("optin");

    By firstNameTextField= By.id("first_name");
    By lastNameTextField= By.id("last_name");

    By companyTextField= By.id("company");

    By addressOneTextField= By.id("address1");

    By addressTwoTextField = By.id("address2");

    By countriesDropDown = By.id("country");

    By stateTextField = By.id("state");

    By cityTextField = By.id("city");

    By zipCodeTextField = By.id("zipcode");

    By mobileNumberTextField = By.id("mobile_number");

    By createAccountButton = By.xpath("//button[@data-qa=\"create-account\"]");

    By enterAccountInfoLabel = By.xpath("(//h2[@class=\"title text-center\"])[1]");


    public CreationAccountPage(Driver driver){
        this.driver=driver;
    }



    //*************************************** Assertions ******************************************************
    @Step("checkthatTheUserIsNavigatedToCreationAccountPageSuccessfully")
    public CreationAccountPage checkthatTheUserIsNavigatedToCreationAccountPageSuccessfully(){
        Assert.assertTrue(driver.element().isDisplayed(enterAccountInfoLabel));
        return this;
    }

    //*************************************** Actions ******************************************************

    @Step("selectGenderRadioButton")
    public CreationAccountPage selectGenderRadioButton(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            driver.element().click(femaleRadioButton);
        } else {
            driver.element().click(maleRadioButton);
        }
        return this;
    }
    @Step("fillNameTextField")
    public CreationAccountPage fillNameTextField(String name){
        driver.element().fillTextField(nameTextField,name);
        return this;
    }
    @Step("fillEmailTextField")
    public CreationAccountPage fillEmailTextField(String email){

        driver.element().fillTextField(emailTextField,email);
        return this;
    }
    @Step("fillPasswordTextField")
    public CreationAccountPage fillPasswordTextField(String password){
        driver.element().fillTextField(passwordTextField,password);
        return this;
    }
    @Step("selectFromDaysDropDown")
    public CreationAccountPage selectFromDaysDropDown (String day){

        driver.element().selectFromDropDownByVisibleText(daysDropDown,day);
        return this;

    }
    @Step("electFromMonthDropDown")
    public CreationAccountPage selectFromMonthDropDown (String month){
        driver.element().selectFromDropDownByVisibleText(monthsDropDown,month);
        return this;

    }
    @Step("selectFromYearDropDown")
    public CreationAccountPage selectFromYearDropDown (String year){

        driver.element().selectFromDropDownByVisibleText(yearsDropDown,year);
        return this;

    }
    @Step("selectNewSletterCheckBo")
    public CreationAccountPage selectNewSletterCheckBox (){
        driver.element().click(newSletterCheckBox);
        return this;
    }
    @Step("selectSpecialOffersCheckBox")
    public CreationAccountPage selectSpecialOffersCheckBox (){

        driver.element().click(specialOffersCheckBox);
        return this;
    }
    @Step("fillFirstNameTextField")
    public CreationAccountPage fillFirstNameTextField (String firstName){
        driver.element().fillTextField(firstNameTextField,firstName);
        return this;

    }
    @Step("fillLastNameTextField")
    public CreationAccountPage fillLastNameTextField (String lastName){
        driver.element().fillTextField(lastNameTextField,lastName);
        return this;

    }
    @Step("fillCompanyTextField")
    public CreationAccountPage fillCompanyTextField (String company){
        driver.element().fillTextField(companyTextField,company);
        return this;

    }
   @Step("fillAddressOneTextField")
    public CreationAccountPage fillAddressOneTextField (String address){
        driver.element().fillTextField(addressOneTextField,address);
        return this;

    }
    @Step("fillAddressTwoTextField")
    public CreationAccountPage fillAddressTwoTextField (String address){
        driver.element().fillTextField(addressTwoTextField,address);
        return this;

    }
    @Step("selectFromCountryDropDown")
    public CreationAccountPage selectFromCountryDropDown (String country){

        driver.element().selectFromDropDownByVisibleText(countriesDropDown,country);
        return this;

    }
    @Step("fillStateTextField")
    public CreationAccountPage fillStateTextField (String state){
        driver.element().fillTextField(stateTextField,state);
        return this;

    }
    @Step("fillCityTextField")
    public CreationAccountPage fillCityTextField (String city){
        driver.element().fillTextField(cityTextField,city);
        return this;

    }
    @Step("fillZipCodeTextField")
    public CreationAccountPage fillZipCodeTextField (String zipCode){
        driver.element().fillTextField(zipCodeTextField,zipCode);
        return this;

    }
    @Step("fillMobileNumberTextField")
    public CreationAccountPage fillMobileNumberTextField (String mobileNumber){
        driver.element().fillTextField(mobileNumberTextField,mobileNumber);
        return this;


    }
    @Step("clickOnCreateAccountButton")
    public RegistrationSuccessPage clickOnCreateAccountButton (){

        driver.element().scrollToElementUsingJs(createAccountButton);
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);

    }
    @Step("fillInCreationAccountForm")
    public RegistrationSuccessPage fillInCreationAccountForm(){
        selectGenderRadioButton("female");
        fillPasswordTextField("123456");
        selectFromDaysDropDown("29");
        selectFromMonthDropDown("August");
        selectFromYearDropDown("2000");
        fillFirstNameTextField("Rana");
        fillLastNameTextField("Hesham");
        fillAddressOneTextField("Alexandria");
        selectFromCountryDropDown("Canada");
        fillStateTextField("alexandria");
        fillCityTextField("alexandria");
        fillZipCodeTextField("0000");
        fillMobileNumberTextField("0123456789");
        clickOnCreateAccountButton();
        return new RegistrationSuccessPage(driver);

    }


}
