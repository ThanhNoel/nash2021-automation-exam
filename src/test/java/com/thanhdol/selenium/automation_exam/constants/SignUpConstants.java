package com.thanhdol.selenium.automation_exam.constants;

import org.openqa.selenium.By;

public class SignUpConstants {

    public static final By EMAIL_ADDRESS_INPUT = By.xpath("//label[@for='email_create']/following-sibling::input");
    public static final By CREATE_ACCOUNT_BUTTON = By.id("SubmitCreate");
    public static final By ACCOUNT_CREATION_FORM_ID_LOCATOR = By.id("account-creation_form");
    public static final String ACCOUNT_CREATION_FORM_GENDER_RADIO_PLACEHOLDER_XPATH = "//div[@class='radio-inline']//text()[contains(.,'%s')]//preceding-sibling::div//input";
    public static final By FIRST_NAME_INPUT = By.id("customer_firstname");
    public static final By LAST_NAME_INPUT = By.id("customer_lastname");
    public static final By EMAIL_INPUT = By.id("email");
    public static final By PWD_INPUT = By.id("passwd");
    public static final By ADDRESS_FIRST_NAME_INPUT = By.id("firstname");
    public static final By ADDRESS_LAST_NAME_INPUT = By.id("lastname");
    public static final By ADDRESS_LINE_1_INPUT = By.id("address1");
    public static final By ADDRESS_CITY_INPUT = By.id("city");
    public static final By ADDRESS_POSTCODE_INPUT = By.id("postcode");
    public static final By STATE_DROPDOWN = By.xpath("//label[@for='id_state']/following-sibling::div");
    public static final By STATE_DROPDOWN_ALL_OPTIONS = By.xpath("//select[@id='id_state']/child::option");
    public static final String STATE_DROPDOWN_OPTION_PLACEHOLDER = "//select[@id='id_state']/child::option[%d]";
    public static final By COUNTRY_DROPDOWN = By.xpath("//label[@for='id_country']/following-sibling::div");
    public static final String COUNTRY_DROPDOWN_OPTION_PLACEHOLDER_TEXT = "//select[@id='id_country']/child::option[text()='%s']";
    public static final By ADDRESS_HOME_PHONE = By.id("phone");
    public static final By ADDRESS_MOBILE_PHONE = By.id("phone_mobile");
    public static final By SUBMIT_BUTTON = By.id("submitAccount");

}
