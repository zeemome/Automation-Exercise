package com.automationexercise.testCases;

import com.automationexercise.base.BasePage;
import com.automationexercise.base.BaseTest;
import org.testng.annotations.Test;

public class SignUpUsingValidCredentials extends BaseTest {

    @Test
    public void verifySignUpUsingValidCredentials(){
        test = extent.createTest("SLDL-101 - Trying to signing up with valid credentials");
        loginPagePom
        pageObjectManager.getHomePage().clickSignUpLogin();
        pageObjectManager.getSignUpPage().clickSignUp();
        test.pass("passed");
        System.out.println("only for github and jenkins");
        System.out.println("Another line from a branch");
        System.out.println("This is for demo purpose");
    }


}
