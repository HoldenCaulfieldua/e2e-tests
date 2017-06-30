package com.company.suites.stub;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by oleg on 6/14/17.
 */
@Slf4j
public class ImplTest extends AbstractSuiteTest {

    @DataProvider(name = "searchInputData")
    public Object[][] searchInputData() {
        return new Object[][]{
                {"http://www.seleniumhq.org/"},
                {"https://www.apache.org/"}
        };
    }

    @Test(dataProvider = "searchInputData")
    public void test(String searchInputData) {
        indexPO.searchInGoogle(searchInputData);
        log.info(driver.getCurrentUrl());
    }
}
