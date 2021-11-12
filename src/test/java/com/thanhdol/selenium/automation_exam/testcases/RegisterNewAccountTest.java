package com.thanhdol.selenium.automation_exam.testcases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thanhdol.selenium.automation_exam.constants.SignUpConstants;
import com.thanhdol.selenium.automation_exam.dataobjects.EGender;
import com.thanhdol.selenium.automation_exam.dataobjects.PersonalAddress;
import com.thanhdol.selenium.automation_exam.dataobjects.PersonalInfo;
import com.thanhdol.selenium.automation_exam.dataobjects.UserRegisterData;
import com.thanhdol.selenium.automation_exam.pageobjects.GeneralPage;
import com.thanhdol.selenium.automation_exam.pageobjects.IndexPage;
import com.thanhdol.selenium.automation_exam.pageobjects.SignUpPage;

public class RegisterNewAccountTest extends AbstractAutomationPracticeTest {

    @Test
    public void whenRegisterNewAccount_ThenUserIsCreated() {
        // go to index page
        GeneralPage testPage = new IndexPage(webDriver);
        testPage.openPage();
        // click sign in link
        testPage.goToSignInPage();
        // "Resource Limit Is Reached", skip test when this is shown as nothing can be done
        By resourceLimitPageTitle = By.xpath("//h1[text()='Resource Limit Is Reached']");
        System.out.println("Went to sign in page");
        // fill random email
        String testEmail = "thanhtest%d@gmail.com";
        testPage.fillTextInElementByLocator(SignUpConstants.EMAIL_ADDRESS_INPUT,
                String.format(testEmail, System.currentTimeMillis()));
        // click sign up
        testPage.clickOnElement(SignUpConstants.CREATE_ACCOUNT_BUTTON);
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(SignUpConstants.ACCOUNT_CREATION_FORM_ID_LOCATOR),
                ExpectedConditions.presenceOfElementLocated(resourceLimitPageTitle)));
        // skip test if hit resource limit page
        assumeTrue(webDriver.findElements(SignUpConstants.ACCOUNT_CREATION_FORM_ID_LOCATOR).size() > 0,
                "Hit resource limit page");
        
        UserRegisterData mockData = buildMockUserRegisterData(testEmail);
        SignUpPage signUpPage = new SignUpPage(webDriver);
        signUpPage.fillSignupForm(mockData);
        signUpPage.submit();
        WebDriverWait waitMyAccountPage = new WebDriverWait(webDriver, 10);
        By myAccountPageHeading = By.xpath("//h1[@class='page-heading' and text()='My account']");
        waitMyAccountPage.until(ExpectedConditions.or(
                ExpectedConditions.presenceOfElementLocated(myAccountPageHeading),
                ExpectedConditions.presenceOfElementLocated(resourceLimitPageTitle)));
        String fullName = "%s %s";
        By fullNameLocator = By.xpath("//a[@class='account']/child::span");
        // skip test if hit resource limit page
        assumeTrue(webDriver.findElements(fullNameLocator).size() > 0,
                "Hit resource limit page");
        String expectedFullName = String.format(fullName,
                mockData.getPersonalInfo().getFirstName(),
                mockData.getPersonalInfo().getLastName());
        assertEquals(
                expectedFullName,
                webDriver.findElement(fullNameLocator).getText());
    }
    
    private UserRegisterData buildMockUserRegisterData(String email) {
        UserRegisterData data = new UserRegisterData();
        PersonalInfo pInfo = new PersonalInfo();
        pInfo.setFirstName(RandomStringUtils.random(10, true, false));
        pInfo.setLastName(RandomStringUtils.random(10, true, false));
        pInfo.setPassword("123456");
        pInfo.setEmail(email);
        pInfo.setGender(new Random().nextBoolean() ? EGender.MISTER : EGender.MISTRESS);
        data.setPersonalInfo(pInfo);
        
        PersonalAddress pAddr = new PersonalAddress();
        pAddr.setFirstName("Thanh" + RandomStringUtils.random(3, true, false));
        pAddr.setLastName("Do" + RandomStringUtils.random(3, true, false));
        pAddr.setAddress(RandomStringUtils.random(10, true, false));
        pAddr.setCity(RandomStringUtils.random(10, true, false));
        pAddr.setPostCode("10000");
        pAddr.setCountry("United States");
        
        pAddr.setHomePhone(RandomStringUtils.random(10, false, true));
        pAddr.setAddressAlias(RandomStringUtils.random(10, true, false));
        data.setPersonalAddress(pAddr);
        return data;
    }

}
