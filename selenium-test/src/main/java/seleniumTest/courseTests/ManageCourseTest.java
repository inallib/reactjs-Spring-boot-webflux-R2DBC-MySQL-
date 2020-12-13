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
public class ManageCourseTest  {
    private WebDriver webDriver;
    private final String URL = "http://localhost:3000/manage";

    @BeforeTest
    public void init(){
        webDriver = TestChomeDriver.getWebDriver();
        webDriver.navigate().to(URL);
    }

    @Test
    public void testCreateCourse() {
        try {
            webDriver.findElement(By.id("title")).sendKeys("title1");
            webDriver.findElement(By.id("author")).sendKeys("author1");
            webDriver.findElement(By.id("category")).sendKeys("category1");

            webDriver.findElement(By.id("save")).click();
            Thread.sleep(1400);
            Assert.assertTrue(webDriver.findElement(By.id("category")).getText().equalsIgnoreCase(""));

        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testGoBackToCourses() {
        try {
            webDriver.findElement(By.id("courseList")).click();

            Thread.sleep(1400);
            Assert.assertTrue(webDriver.findElement(By.tagName("h2")).getText().equalsIgnoreCase("Courses"));

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
