package com.thanhdol.selenium.automation_exam.testcases;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractAutomationPracticeTest {

    protected WebDriver webDriver;

    @BeforeEach
    public void beforeMethod() {
    //        WebDriverManager.firefoxdriver().browserVersion(null).setup();
    //      webDriver = new FirefoxDriver();
            WebDriverManager.chromedriver().browserVersion(null).setup();
    
            webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    @AfterEach
    public void afterMethod() {
        webDriver.quit();
    }

}
