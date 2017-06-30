package com.company.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by oleg on 6/28/17.
 */
public class IndexPO extends BasePO {

    private static final By SEARCH_INPUT = By.name("q");

    public IndexPO(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        return SEARCH_INPUT;
    }

    public IndexPO searchInGoogle(String keyword) {
        driver.findElement(SEARCH_INPUT).sendKeys(keyword);
        return this;
    }
}
