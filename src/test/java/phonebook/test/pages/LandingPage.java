package phonebook.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private WebDriver driver;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() {
        driver.get("http://localhost/phonebook/");
        driver.manage().window().maximize();
    }

    public By clickAddButton() {
        return By.linkText("Adicionar");
    }

    public By clickConsultButton() {
        return By.linkText("Consultar");
    }
}
