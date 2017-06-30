package com.company.suites;

import com.company.util.driver.WebDriverFactory;
import com.company.util.exceptions.UnsupportedBrowserException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import static com.company.util.TestProperties.getProps;

@Slf4j
public abstract class BaseTest extends Assert {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected static String server_host;
    protected static String server_port;

    @BeforeTest(alwaysRun = true)
    @Parameters({"browser", "platform"})
    public void setupBeforeTest(final String browser, final String platform) {
        log.info(browser + platform);
        try {
            server_host = getProps().getProperty("server.host");
            server_port = getProps().getProperty("server.port");
            driver = WebDriverFactory.createDriver(browser, platform);
            Thread.currentThread().setName(browser+"/"+platform);
            log.info("Driver for " + browser + " loaded");
        } catch (final UnsupportedBrowserException | IOException e) {
            log.error(e.getMessage());
        }
        wait = new WebDriverWait(driver, 5);
    }

    @AfterTest(alwaysRun = true)
    public void tearDownAfterTest() {
        driver.quit();
    }
}