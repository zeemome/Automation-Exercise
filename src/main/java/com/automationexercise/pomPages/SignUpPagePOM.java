package com.automationexercise.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignUpPagePOM {
    private WebDriver driver;

    // Locators (Signup form fields)
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    // (after clicking signup, full registration form appears — add those fields too)
    @FindBy(id = "id_gender1")
    private WebElement mrTitleRadio;

    @FindBy(id = "id_gender2")
    private WebElement mrsTitleRadio;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "days")
    private WebElement daysDropdown;

    @FindBy(id = "months")
    private WebElement monthsDropdown;

    @FindBy(id = "years")
    private WebElement yearsDropdown;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    // Constructor
    public SignUpPagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterName(String name){
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void clickSignUp(){
        signUpButton.click();
    }

    public void selectTitle(String title){
        if(title.equalsIgnoreCase("Mr")){
            mrTitleRadio.click();
        } else {
            mrsTitleRadio.click();
        }
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void enterAddressDetails(String firstName, String lastName, String address,
                                    String state, String city, String zipcode, String mobile){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        addressInput.sendKeys(address);
        stateInput.sendKeys(state);
        cityInput.sendKeys(city);
        zipcodeInput.sendKeys(zipcode);
        mobileInput.sendKeys(mobile);
    }

    public void clickCreateAccount(){
        createAccountButton.click();
    }

    // Combined method for a full signup flow
    public void completeSignUp(String name, String email, String password,
                               String firstName, String lastName, String address,
                               String state, String city, String zipcode, String mobile) {
        enterName(name);
        enterEmail(email);
        clickSignUp();
        selectTitle("Mr");
        enterPassword(password);
        enterAddressDetails(firstName, lastName, address, state, city, zipcode, mobile);
        clickCreateAccount();
    }

    public void doSignUpUsingTestData(){

    }
}
