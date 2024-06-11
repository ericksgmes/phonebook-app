package phonebook.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConsultContactPage {
    private WebDriver driver;

    public ConsultContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickFirstReadButton() {
        driver.findElement(By.cssSelector("tr:nth-child(1) .button-read:nth-child(1)")).click();
    }

    public void clickFirstDeleteButton() {
        driver.findElement(By.cssSelector("tr:nth-child(1) .button-read:nth-child(2)")).click();
    }
}
