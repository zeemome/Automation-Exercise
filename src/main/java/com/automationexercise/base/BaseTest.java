package com.automationexercise.base;

import com.automationexercise.browserFactory.DriverFactory;
import com.automationexercise.managers.PageObjectManager;
import com.automationexercise.util.ConfigReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public ExtentReports extent;
    public ExtentTest test;
    public ExtentSparkReporter spark;

    @BeforeSuite
    public void setUpExtentReport(){
        spark = new ExtentSparkReporter("target/ExtentReport.html");
    }

    @BeforeTest
    public void setTest() {
        extent = new ExtentReports();
        extent.attachReporter(spark);

    }

    @BeforeClass
    public void setUp() {
        ConfigReader.loadConfig();
        String browser = ConfigReader.get("browser");
        String url = ConfigReader.get("baseUrl");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        driver = DriverFactory.launchBrowser(browser, headless);
        driver.navigate().to(url);

        pageObjectManager = new PageObjectManager(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void flush(){
        extent.flush();
    }


}
