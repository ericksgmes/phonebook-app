package phonebook.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddContactPage {
    private WebDriver driver;
    public AddContactPage(WebDriver driver) {
        this.driver = driver;
    }
    public void enterName(String name) {
        driver.findElement(By.id("nome")).sendKeys(name);
    }

    public void enterPhone(String phone) {
        driver.findElement(By.id("tel")).sendKeys(phone);
    }

}
