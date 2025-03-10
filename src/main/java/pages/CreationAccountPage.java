package pages;

import driverfactory.Driver;
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

    public CreationAccountPage checkthatTheUserIsNavigatedToCreationAccountPageSuccessfully(){
        Assert.assertTrue(driver.element().isDisplayed(enterAccountInfoLabel));
        return this;
    }

    //*************************************** Actions ******************************************************

    public CreationAccountPage selectGenderRadioButton(String gender) {
        if (gender.equalsIgnoreCase("female")) {
            driver.element().click(femaleRadioButton);
        } else {
            driver.element().click(maleRadioButton);
        }
        return this;
    }

    public CreationAccountPage fillNameTextField(String name){
        driver.element().fillTextField(nameTextField,name);
        return this;
    }

    public CreationAccountPage fillEmailTextField(String email){

        driver.element().fillTextField(emailTextField,email);
        return this;
    }
    public CreationAccountPage fillPasswordTextField(String password){
        driver.element().fillTextField(passwordTextField,password);
        return this;
    }

    public CreationAccountPage selectFromDaysDropDown (String day){

        driver.element().selectFromDropDownByVisibleText(daysDropDown,day);
        return this;

    }

    public CreationAccountPage selectFromMonthDropDown (String month){
        driver.element().selectFromDropDownByVisibleText(monthsDropDown,month);
        return this;

    }

    public CreationAccountPage selectFromYearDropDown (String year){

        driver.element().selectFromDropDownByVisibleText(yearsDropDown,year);
        return this;

    }

    public CreationAccountPage selectNewSletterCheckBox (){
        driver.element().click(newSletterCheckBox);
        return this;
    }
    public CreationAccountPage selectSpecialOffersCheckBox (){

        driver.element().click(specialOffersCheckBox);
        return this;
    }

    public CreationAccountPage fillFirstNameTextField (String firstName){
        driver.element().fillTextField(firstNameTextField,firstName);
        return this;

    }

    public CreationAccountPage fillLastNameTextField (String lastName){
        driver.element().fillTextField(lastNameTextField,lastName);
        return this;

    }

    public CreationAccountPage fillCompanyTextField (String company){
        driver.element().fillTextField(companyTextField,company);
        return this;

    }

    public CreationAccountPage fillAddressOneTextField (String address){
        driver.element().fillTextField(addressOneTextField,address);
        return this;

    }

    public CreationAccountPage fillAddressTwoTextField (String address){
        driver.element().fillTextField(addressTwoTextField,address);
        return this;

    }

    public CreationAccountPage selectFromCountryDropDown (String country){

        driver.element().selectFromDropDownByVisibleText(countriesDropDown,country);
        return this;

    }

    public CreationAccountPage fillStateTextField (String state){
        driver.element().fillTextField(stateTextField,state);
        return this;

    }

    public CreationAccountPage fillCityTextField (String city){
        driver.element().fillTextField(cityTextField,city);
        return this;

    }

    public CreationAccountPage fillZipCodeTextField (String zipCode){
        driver.element().fillTextField(zipCodeTextField,zipCode);
        return this;

    }

    public CreationAccountPage fillMobileNumberTextField (String mobileNumber){
        driver.element().fillTextField(mobileNumberTextField,mobileNumber);
        return this;


    }

    public RegistrationSuccessPage clickOnCreateAccountButton (){

        driver.element().scrollToElementUsingJs(createAccountButton);
        driver.element().click(createAccountButton);
        return new RegistrationSuccessPage(driver);

    }

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
