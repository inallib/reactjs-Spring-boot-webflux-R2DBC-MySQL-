package main.java.seleniumTest.courseTests;

import main.java.seleniumTest.core.GenerateReport;
import main.java.seleniumTest.core.TestChomeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(GenerateReport.class)
public class CoursesTest {
    private WebDriver webDriver;
    private final String URL = "http://localhost:3000/courses";

    @BeforeTest
    public void init(){
        webDriver = TestChomeDriver.getWebDriver();
        webDriver.navigate().to(URL);
    }

    @Test
    public void testClickTitle() {
        try {
            webDriver.findElement(By.linkText("title1")).click();
            Thread.sleep(1400);
            Assert.assertTrue(webDriver.findElement(By.tagName("h2")).getText().equalsIgnoreCase("Manage Courses"));
        }catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @AfterTest
    public void closeWebDriver()
    {
        try {
            webDriver.close();
            webDriver.quit();
        }catch (Exception e){}
    }
}
