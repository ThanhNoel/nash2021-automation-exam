package com.thanhdol.selenium.automation_exam.pageobjects;

import org.openqa.selenium.WebDriver;

public class IndexPage extends GeneralPage {

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected String getUrl() {
        return getBaseUrl();
    }

}
