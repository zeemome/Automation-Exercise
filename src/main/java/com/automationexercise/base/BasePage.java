package com.automationexercise.base;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends BaseTest {

    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void waitForElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element) {
        waitForElement(element);
        element.click();
    }

    public void insertText(WebElement element, String text) {
        waitForElement(element);
        element.sendKeys(text);
    }

    public String getText(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    public boolean isDisplayed(WebElement element) {
        waitForElement(element);
        try {
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }


}
