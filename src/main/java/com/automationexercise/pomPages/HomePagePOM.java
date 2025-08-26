package com.automationexercise.pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {

    private WebDriver driver;

    @FindBy(xpath = "//a[.=' Home']")
    private WebElement homeLink;

    @FindBy(xpath = "//a[contains(text(),'Products')]")
    private WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartList;

    @FindBy(xpath = "//a[contains(text(),' Signup / Login')]")
    private WebElement signUpLoginLinkButton;

    @FindBy(xpath = "//a[contains(text(),'API Testing')]")
    private WebElement apiTestingLinkButton;

    @FindBy(xpath = "//a[contains(text(),'Test Cases')]")
    private WebElement testCasesLinkButton;

    @FindBy(xpath = "//a[contains(text(),'Video Tutorials')]")
    private WebElement videoTutorialLinkButton;

    @FindBy(xpath = "//a[contains(text(),'Contact us')]")
    private WebElement contactUsLinkButton;

    @FindBy(xpath = "(//button[.='Test Cases'])")
    private WebElement testCasesButtonOnWebPageScreen;


    public HomePagePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickTestCasesLink() {
        testCasesLinkButton.click();
    }

    public LoginPagePOM clickSignUpLogin() {
        signUpLoginLinkButton.click();
        return new LoginPagePOM(driver);
    }

    public void goToHomePage() {
        homeLink.click();
    }

}


