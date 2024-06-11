package phonebook.test;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @Before
    public void setUp() {
        driver = DriverSetup.getDriver();
        faker = new Faker();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void acceptAlert(String expectedAlertText) {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertEquals(expectedAlertText, alertText);
            alert.accept();
        } catch (NoAlertPresentException e) {
            Assert.fail("Alert not accepted");
        }
    }

    protected void waitForElementToLoad(By locator) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(700))
                .until(ExpectedConditions.elementToBeClickable(locator))
                .click();

    }
}
