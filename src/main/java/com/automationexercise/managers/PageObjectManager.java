package com.automationexercise.managers;

import com.automationexercise.pomPages.HomePagePOM;
import com.automationexercise.pomPages.LoginPagePOM;
import com.automationexercise.pomPages.SignUpPagePOM;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private HomePagePOM homePage;
    private LoginPagePOM loginPage;
    private SignUpPagePOM signUpPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePagePOM getHomePage() {
        if (homePage == null) {
            homePage = new HomePagePOM(driver);
        }
        return homePage;
    }

    public LoginPagePOM getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPagePOM(driver);
        }
        return loginPage;
    }

    public SignUpPagePOM getSignUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPagePOM(driver);
        }
        return signUpPage;
    }
}
