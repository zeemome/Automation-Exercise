package com.automationexercise.pomPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private WebDriver driver;

    // Locators for various elements on the dashboard
    private By logo = By.id("orangehrm-logo"); // Replace with actual logo locator
    private By leaveSubmodule = By.xpath("//span[text()='Leave']");  // Adjust XPath as per actual element
    private By adminSubmodule = By.xpath("//span[text()='Admin']");
    private By pimSubmodule = By.xpath("//span[text()='PIM']");
    private By recruitmentSubmodule = By.xpath("//span[text()='Recruitment']");
    private By dashboardSubmoduleOption = By.cssSelector(".dashboard-submodule");  // Adjust CSS selector

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to check existence of elements
    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isLeaveSubmoduleDisplayed() {
        return driver.findElement(leaveSubmodule).isDisplayed();
    }

    public boolean isAdminSubmoduleDisplayed() {
        return driver.findElement(adminSubmodule).isDisplayed();
    }

    public boolean isPIMSubmoduleDisplayed() {
        return driver.findElement(pimSubmodule).isDisplayed();
    }

    public boolean isRecruitmentSubmoduleDisplayed() {
        return driver.findElement(recruitmentSubmodule).isDisplayed();
    }

    public boolean isDashboardSubmoduleHighlighted() {
        WebElement submodule = driver.findElement(dashboardSubmoduleOption);
        return submodule.getCssValue("background-color").equals("rgb(255, 255, 255)"); // Adjust based on actual highlight color
    }
}