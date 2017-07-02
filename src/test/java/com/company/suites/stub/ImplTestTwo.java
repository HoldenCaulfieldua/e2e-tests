package com.company.suites.stub;

import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Slf4j
public class ImplTestTwo extends AbstractSuiteTest {

    @DataProvider(name = "searchInputDataTestTwo")
    public Object[][] searchInputDataTestTwo() {
        return new Object[][]{
                {"http://www.seleniumhq.org/"},
                {"https://www.apache.org/"}
        };
    }

    @DataProvider(name = "searchInputDataTwoTestTwo")
    public Object[][] searchInputDataTwoTestTwo() {
        return new Object[][]{
                {"https://www.apple.com/"},
                {"https://www.swissquote.ch/"}
        };
    }

    @Test(dataProvider = "searchInputDataTestTwo")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("TMS-LINK-123")
    public void testTestTwo(String searchInputData) {
        indexPO.searchInGoogle(searchInputData);
        log.info("Hello from testtesttwo!");
        assertNotNull(driver.getCurrentUrl(), driver.getCurrentUrl());
    }

    @Test(dataProvider = "searchInputDataTwoTestTwo")
    @Severity(SeverityLevel.TRIVIAL)
    @Issue("JIRA-1234")
    public void anotherTestTestTwo(String searchInputData) {
        indexPO.searchInGoogle(searchInputData);
        log.info("Hello from anotherTesttesttwo!");
        assertNotNull(null, driver.getCurrentUrl());
    }
}
