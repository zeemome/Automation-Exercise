package com.automationexercise.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePOM {
    private WebDriver driver;

    // Locators
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private WebElement loginButton;

    // Constructor
    public LoginPagePOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }

    // A combined method (optional)
    public void login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }
}
