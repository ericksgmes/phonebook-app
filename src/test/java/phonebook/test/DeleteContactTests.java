package phonebook.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import phonebook.test.pages.AddContactPage;
import phonebook.test.pages.ConsultContactPage;
import phonebook.test.pages.LandingPage;

public class DeleteContactTests extends BaseTest {
    private LandingPage landingPage;
    private AddContactPage addContactPage;
    private ConsultContactPage consultContactPage;

    @Before
    public void setUp() {
        super.setUp();
        landingPage = new LandingPage(driver);
        addContactPage = new AddContactPage(driver);
        consultContactPage = new ConsultContactPage(driver);
    }


    @Test
    @DisplayName("Should exclude valid contact")
    public void shouldExcludeValidContact() {
        landingPage.open();
        waitForElementToLoad(driver, By.linkText("Adicionar"));
        landingPage.clickAddButton();
        waitForElementToLoad(driver, By.id("nome"));
        addContactPage.enterName(faker.name().fullName());
        waitForElementToLoad(driver, By.id("tel"));
        addContactPage.enterPhone(faker.phoneNumber().cellPhone());
        waitForElementToLoad(driver, By.cssSelector(".button-create"));
        addContactPage.clickCreate();
        acceptAlert("Contato adicionado com sucesso!");
        landingPage.open();
        waitForElementToLoad(driver, By.linkText("Consultar"));
        landingPage.clickConsultButton();
        waitForElementToLoad(driver, By.cssSelector("tr:nth-child(1) .button-read:nth-child(2)"));
        consultContactPage.clickFirstDeleteButton();
        acceptAlert("Tem certeza de que deseja excluir este contato?");
        acceptAlert("Contato excluído com sucesso!");
    }
}
