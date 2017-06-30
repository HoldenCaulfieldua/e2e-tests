package com.company.suites.stub;

import com.company.framework.pageobjects.IndexPO;
import com.company.suites.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * Created by oleg on 6/27/17.
 */
public abstract class AbstractSuiteTest extends BaseTest {

    protected IndexPO indexPO;

    @BeforeClass
    public void beforeClass() {
        indexPO = new IndexPO(driver);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver.get(buildServerLink());
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    private String buildServerLink() {
        return server_host +
                ":" +
                server_port;
    }
}
