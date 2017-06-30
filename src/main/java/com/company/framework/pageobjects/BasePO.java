package com.company.framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePO {

    protected WebDriver driver;

    public BasePO(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract By getUniqueElement();

    protected boolean isLoaded() {
        return driver.findElements(getUniqueElement()).size() > 0;
    }
}