package com.thanhdol.selenium.automation_exam.constants;

import org.openqa.selenium.By;

public class GeneralConstants {

    public static final By PRODUCT_NAME_LOCATOR = By.xpath("//ul[contains(@class,'product_list')]//a[@class='product-name']");
    public static final String CATEGORY_LOCATOR_TEMPLATE = "//div[@id='block_top_menu']//a[@title='%s']";
    public static final String CATEGORY_SUB_CATEGORY_LOCATOR_TEMPLATE = CATEGORY_LOCATOR_TEMPLATE + "/following-sibling::ul/descendant::a[@title='%s']";

}
