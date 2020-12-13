package main.java.seleniumTest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChomeDriver {
    static WebDriver webDriver;

    public static WebDriver getWebDriver(){
        if (webDriver == null) {
            System.setProperty(
                    "webdriver.chrome.driver",
                    "C:/NonSystems/Saurav/hackathons/Candela labs/selenium-test/src/main/resources/chromedriver.exe");
            webDriver = new ChromeDriver();
            return webDriver;
        }
        return webDriver;
    }
}
