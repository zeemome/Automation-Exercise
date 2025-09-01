package com.automationexercise.managers;

import com.automationexercise.pomPages.DashboardPage;
import com.automationexercise.pomPages.HomePagePOM;
import com.automationexercise.pomPages.LoginPagePOM;
import com.automationexercise.pomPages.SignUpPagePOM;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public HomePagePOM homePage;
    public LoginPagePOM loginPage;
    public SignUpPagePOM signUpPage;
    public DashboardPage dashboardPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePagePOM(driver);
        loginPage = new LoginPagePOM(driver);
        signUpPage = new SignUpPagePOM(driver);
        dashboardPage = new DashboardPage(driver);

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
