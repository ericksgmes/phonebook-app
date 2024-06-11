package phonebook.test;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
}
