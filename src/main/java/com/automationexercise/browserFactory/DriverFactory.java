package com.automationexercise.browserFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    //this will avoid driver clashes when running in parallel tests
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver launchBrowser(String browser, boolean headless){
        if(browser.equalsIgnoreCase("chrome")){
            launchChrome(headless);
        }
        else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("mozilla")){
            launchFirefox(headless);
        }
        else if(browser.equalsIgnoreCase("safari")){
            launchSafari(headless);
        }
        else if(browser.equalsIgnoreCase("edge")){
            launchEdge(headless);
        }
        else{
            throw new IllegalArgumentException("Browser not supported : " + browser);
        }

        driver.get().manage().window().maximize();
        driver.get().manage().deleteAllCookies();

        return driver.get();
    }

    private static void launchChrome(boolean headless){
        ChromeOptions chromeOptions = new ChromeOptions();
        if (headless) {
            chromeOptions.addArguments("--headless=new");  // modern headless
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
        }
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(chromeOptions));
    }

    private static void launchFirefox(boolean headless){
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headless) {
            firefoxOptions.addArguments("--headless");
        }
        driver.set(new FirefoxDriver());
    }

    private static void launchEdge(boolean headless){
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        if (headless) {
            edgeOptions.addArguments("--headless=new");
            edgeOptions.addArguments("--disable-gpu");
        }
        driver.set(new EdgeDriver());
    }

    private static void launchSafari(boolean headless){
        WebDriverManager.safaridriver().setup();
        driver.set(new SafariDriver());
    }
}
