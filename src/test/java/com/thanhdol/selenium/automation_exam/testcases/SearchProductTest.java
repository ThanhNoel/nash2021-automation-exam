package com.thanhdol.selenium.automation_exam.testcases;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.thanhdol.selenium.automation_exam.constants.GeneralConstants;
import com.thanhdol.selenium.automation_exam.pageobjects.GeneralPage;
import com.thanhdol.selenium.automation_exam.pageobjects.IndexPage;

public class SearchProductTest extends AbstractAutomationPracticeTest {
    
    @Test
    public void whenSearchProduct_ThenResultsShown() throws InterruptedException {
        // go to index page
        GeneralPage testPage = new IndexPage(webDriver);
        testPage.openPage();

        String category = "Women";
        By womenCategoryLocator = testPage.getCategoryLocator(category);
        testPage.hoverElementByLocator(womenCategoryLocator);
        String subCategory = "T-shirts";
        By tshirtUnderWomenCategory = testPage.getSubCategoryLocatorFromHoverCategory(category, subCategory);
        testPage.clickOnElement(tshirtUnderWomenCategory);
        
        List<WebElement> productNameElements = webDriver.findElements(GeneralConstants.PRODUCT_NAME_LOCATOR);
        String firstProductName = productNameElements.get(0).getText();
        
        By searchBox = By.id("search_query_top");
        testPage.fillTextInElementByLocator(searchBox, firstProductName);
        By searchButton = By.name("submit_search");
        testPage.clickOnElement(searchButton);
        
        List<WebElement> productNameElementsSearched = webDriver.findElements(GeneralConstants.PRODUCT_NAME_LOCATOR);
        assertTrue(productNameElementsSearched.size() >= 1,
                "Expect to find at least 1 product when search by existing product name");
        for (WebElement webElement : productNameElementsSearched) {
            String prodName = webElement.getText();
            assertTrue(prodName.contains(firstProductName), "Expect product searched to have name contain search term");
        }
    }

}
