package com.company.util.driver;

import com.company.util.exceptions.UnsupportedBrowserException;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.utils.URIBuilder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

@Slf4j
public class WebDriverFactory {

	public static synchronized WebDriver createDriver(String browser, String platform) throws UnsupportedBrowserException {

		DesiredCapabilities desiredCapabilities;

		switch (browser) {
			case "chrome":
				desiredCapabilities = DesiredCapabilities.chrome();
				desiredCapabilities.setVersion("60.0");
				break;
			case "firefox":
				desiredCapabilities = DesiredCapabilities.firefox();
				desiredCapabilities.setVersion("54.0");
				break;
			case "opera":
				desiredCapabilities = DesiredCapabilities.operaBlink();
				desiredCapabilities.setBrowserName("operablink");
                desiredCapabilities.setCapability("operaOptions", new HashMap<String, Object>(){
                    {
                        put("binary", "/usr/bin/opera");
                    }
                });
				desiredCapabilities.setVersion("47.0");
				break;
			default:
				throw new UnsupportedBrowserException(browser + " browser is not supported yet");
		}

		switch (platform) {
			case "windows":
				desiredCapabilities.setCapability("platform", Platform.WINDOWS);
				break;
			case "linux":
				desiredCapabilities.setCapability("platform", Platform.LINUX);
				break;
			case "any":
				desiredCapabilities.setCapability("platform", Platform.ANY);
				break;
		}
		try {
			return new RemoteWebDriver(buildUrl(), desiredCapabilities);
		}
		catch (MalformedURLException e) {
			log.error("Failed to create driver. Reason:\n" + e.getMessage());
			return null;
		}
	}

	private static synchronized URL buildUrl() throws MalformedURLException {
		URIBuilder uriBuilder= new URIBuilder();
		try {
			return uriBuilder.setScheme("http").setHost("localhost").setPort(4444).setPath("/wd/hub").build().toURL();
		} catch (URISyntaxException e) {
			log.error(e.getMessage());
			return null;
		}
	}
}
