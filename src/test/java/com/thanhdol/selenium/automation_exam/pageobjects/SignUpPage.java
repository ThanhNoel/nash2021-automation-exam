package com.thanhdol.selenium.automation_exam.pageobjects;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.thanhdol.selenium.automation_exam.constants.SignUpConstants;
import com.thanhdol.selenium.automation_exam.dataobjects.PersonalAddress;
import com.thanhdol.selenium.automation_exam.dataobjects.PersonalInfo;
import com.thanhdol.selenium.automation_exam.dataobjects.UserRegisterData;

public class SignUpPage extends GeneralPage {
    
    public SignUpPage(WebDriver webDriver) {
        super(webDriver);
    }
    
    public void fillSignupForm(UserRegisterData registerData) {
        fillPersonalInfo(registerData);
        fillAddress(registerData);
    }

    public void fillPersonalInfo(UserRegisterData registerData) {
        PersonalInfo personalInfo = registerData.getPersonalInfo();
        String correctGenderRadioXpath = String.format(
                SignUpConstants.ACCOUNT_CREATION_FORM_GENDER_RADIO_PLACEHOLDER_XPATH,
                personalInfo.getGender().getValue());
        clickOnElement(By.xpath(correctGenderRadioXpath));
        fillTextInElementByLocator(SignUpConstants.FIRST_NAME_INPUT, personalInfo.getFirstName());
        fillTextInElementByLocator(SignUpConstants.LAST_NAME_INPUT, personalInfo.getLastName());
        assumeTrue(webDriver.findElements(SignUpConstants.EMAIL_INPUT).size() > 0);
        if (StringUtils.isBlank(webDriver.findElement(SignUpConstants.EMAIL_INPUT).getAttribute("value"))) {
            System.out.println("Email field empty, filling...");
            fillTextInElementByLocator(SignUpConstants.EMAIL_INPUT, personalInfo.getEmail());
        }
        fillTextInElementByLocator(SignUpConstants.PWD_INPUT, personalInfo.getPassword());
        // TODO fill non required field too
        System.out.println("Filled personal info");
    }
    
    public void fillAddress(UserRegisterData mockData) {
        PersonalAddress address = mockData.getPersonalAddress();
        fillTextInElementByLocator(SignUpConstants.ADDRESS_FIRST_NAME_INPUT, address.getFirstName());
        fillTextInElementByLocator(SignUpConstants.ADDRESS_LAST_NAME_INPUT, address.getLastName());
        fillTextInElementByLocator(SignUpConstants.ADDRESS_LINE_1_INPUT, address.getAddress());
        fillTextInElementByLocator(SignUpConstants.ADDRESS_CITY_INPUT, address.getAddress());
        String countryElement = String.format(SignUpConstants.COUNTRY_DROPDOWN_OPTION_PLACEHOLDER_TEXT, address.getCountry());
        clickOnElement(SignUpConstants.COUNTRY_DROPDOWN);
        clickOnElement(By.xpath(countryElement));
        if ("United States".equals(address.getCountry())) {
            fillTextInElementByLocator(SignUpConstants.ADDRESS_POSTCODE_INPUT, address.getPostCode());
            System.out.println("Selecting state...");
            clickOnElement(SignUpConstants.STATE_DROPDOWN);
            int numberOfStateOptions = webDriver.findElements(SignUpConstants.STATE_DROPDOWN_ALL_OPTIONS).size();
            // select last option
            clickOnElement(By.xpath(String.format(SignUpConstants.STATE_DROPDOWN_OPTION_PLACEHOLDER, numberOfStateOptions)));
        }
        fillTextInElementByLocator(SignUpConstants.ADDRESS_HOME_PHONE, address.getHomePhone());
        fillTextInElementByLocator(SignUpConstants.ADDRESS_MOBILE_PHONE, address.getMobilePhone());
        System.out.println("Filled adddress");
    }
    
    public void submit() {
        clickOnElement(SignUpConstants.SUBMIT_BUTTON);
    }

    @Override
    protected String getUrl() {
        return getBaseUrl() + "?controller=authentication";
    }

}
