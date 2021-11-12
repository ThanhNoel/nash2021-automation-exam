package com.thanhdol.selenium.automation_exam.pageobjects;

import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thanhdol.selenium.automation_exam.constants.GeneralConstants;

public abstract class GeneralPage {
    
    protected WebDriver webDriver;
    private static final String BASE_URL = "http://automationpractice.com/index.php";
    private static final By SIGN_IN_LINK = By.className("login");
    
    public GeneralPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public void openPage() {
        webDriver.get(getUrl());
        assumeFalse(webDriver.getPageSource().contains("Resource limit reached"),
                "Hit resource limit page, skipping test");
    }
    public void clickOnElement(By locator) {
        assumeElementExistByLocator(locator);
        webDriver.findElement(locator).click();

        assumeFalse(webDriver.getPageSource().contains("Resource limit reached"),
                "Hit resource limit page, skipping test");
    }
    public void goToSignInPage() {
        clickOnElement(SIGN_IN_LINK);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.titleContains("Login"));

        assumeFalse(webDriver.getPageSource().contains("Resource limit reached"),
                "Hit resource limit page, skipping test");
    }

    public void hoverElementByLocator(By elementLocator) {
        WebElement elementToHover = webDriver.findElement(elementLocator);
        Actions action = new Actions(webDriver);
        action.moveToElement(elementToHover).perform();
    }

    public void fillTextInElementByLocator(By locator, String text) {
        if (StringUtils.isEmpty(text)) {
            System.out.println("Warning!!! Tried to fill empty text to field " + locator);
            return;
        }
        assumeElementExistByLocator(locator);
        System.out.println("Filling in text " + text + " to locator " + locator);
        webDriver.findElement(locator).sendKeys(text);
    }

    /*
     * Will skip test case if element not exist
     */
    private void assumeElementExistByLocator(By locator) {
        assumeTrue(webDriver.findElements(locator).size() > 0, "Element by " + locator.toString() + " not found, skipping test");
    }
    protected String getBaseUrl() {
        return BASE_URL;
    }
    protected abstract String getUrl();


    public By getCategoryLocator(String category) {
        return By.xpath(String.format(GeneralConstants.CATEGORY_LOCATOR_TEMPLATE, category));
    }

    public By getSubCategoryLocatorFromHoverCategory(String category, String subCategory) {
        return By.xpath(
                String.format(GeneralConstants.CATEGORY_SUB_CATEGORY_LOCATOR_TEMPLATE, category, subCategory));
    }
}
