package com.company.suites.stub;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.company.framework.pageobjects.IndexPO;
import com.company.suites.BaseTest;


public abstract class AbstractSuiteTest extends BaseTest {

    protected IndexPO indexPO;

    @BeforeMethod
    public void beforeMethod() {
        indexPO = new IndexPO(driver);
        driver.get(buildServerLink());
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    private String buildServerLink() {
        return server_host +
                ":" +
                server_port;
    }
}
