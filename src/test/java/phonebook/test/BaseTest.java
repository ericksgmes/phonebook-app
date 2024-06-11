package phonebook.test;

import com.github.javafaker.Faker;
import org.junit.Before;
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
}
