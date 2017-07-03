package com.company.suites.stub;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ImplTestTwo extends AbstractSuiteTest {

    @DataProvider(name = "searchInputData")
    public Object[][] searchInputData() {
        return new Object[][]{
                {"http://www.seleniumhq.org/"},
                {"https://www.apache.org/"}
        };
    }

    @DataProvider(name = "searchInputDataTwo")
    public Object[][] searchInputDataTwo() {
        return new Object[][]{
                {"https://www.apple.com/"},
                {"https://www.swissquote.ch/"}
        };
    }

    @Test(dataProvider = "searchInputData")
    public void testTwo(String searchInputData) {
        indexPO.searchInGoogle(searchInputData);
        assertNotNull(driver.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test(dataProvider = "searchInputDataTwo")
    public void testThree(String searchInputData) {
        indexPO.searchInGoogle(searchInputData);
        assertNotNull(driver.getCurrentUrl());
    }
}
