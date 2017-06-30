package com.company.util.driver;

import com.company.util.exceptions.UnsupportedBrowserException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by oleg on 6/14/17.
 */
@Slf4j
public class WebDriverFactory {

    public static synchronized WebDriver createDriver(String browser, String platform) throws UnsupportedBrowserException {

        DesiredCapabilities desiredCapabilities;

        switch (browser) {
            case "chrome":
                desiredCapabilities = DesiredCapabilities.chrome();
                break;
            case "firefox":
                desiredCapabilities = DesiredCapabilities.firefox();
                break;
            default:
                throw new UnsupportedBrowserException(browser + " browser is not supported yet");
        }

        switch (platform) {
            case "windows":
                desiredCapabilities.setCapability("platform", Platform.WINDOWS);
                break;
            case "linux":
                desiredCapabilities.setCapability("platform", Platform.LINUX.family());
                break;
            default:
                desiredCapabilities.setCapability("platform", Platform.ANY);
                break;
        }
        try {
            return new RemoteWebDriver(buildUrl(), desiredCapabilities);
        } catch (MalformedURLException e) {
            log.error("Failed to create driver. Reason:\n" + e.getMessage());
            return null;
        }
    }

    private static synchronized URL buildUrl() throws MalformedURLException {
        return new URL(new StringBuffer()
                .append("http://")
                .append("127.0.0.1")
                .append(":")
                .append("4444")
                .append("/wd/hub")
                .toString());
    }
}
