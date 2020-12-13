package main.java.seleniumTest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.misc.ClassLoaderUtil;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class TestChomeDriver {
    static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        if (webDriver == null) {
            ClassLoader classLoader = TestChomeDriver.class.getClassLoader();
            File driverFile = new File(classLoader.getResource("chromedriver.exe").getFile());

            System.setProperty(
                    "webdriver.chrome.driver",
                    driverFile.getPath());
            webDriver = new ChromeDriver();
            return webDriver;
        }
        return webDriver;
    }
}
