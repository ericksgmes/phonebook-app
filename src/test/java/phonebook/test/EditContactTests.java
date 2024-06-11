package phonebook.test;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.*;
import phonebook.test.pages.AddContactPage;
import phonebook.test.pages.ConsultContactPage;
import phonebook.test.pages.LandingPage;

public class EditContactTests extends BaseTest {
    private LandingPage landingPage;
    private ConsultContactPage consultContactPage;
    private AddContactPage addContactPage;

    @Before
    public void setUp() {
        super.setUp();
        landingPage = new LandingPage(driver);
        consultContactPage = new ConsultContactPage(driver);
        addContactPage = new AddContactPage(driver);
    }

    @Test
    @DisplayName("Should edit the name of a contact")
    public void shouldEditTheNameOfAContact() {
        landingPage.open();
        landingPage.clickAddButton();
        addContactPage.enterName(faker.leagueOfLegends().champion());
        addContactPage.enterPhone(faker.phoneNumber().cellPhone());
        addContactPage.clickCreate();
        acceptAlert("Contato adicionado com sucesso!");
        landingPage.open();
        landingPage.clickAddButton();
        consultContactPage.clickFirstReadButton();
        WebElement nameInput = consultContactPage.getFirstContactNameInput();
        nameInput.click();
        nameInput.clear();
        nameInput.sendKeys(faker.name().firstName());
        consultContactPage.clickFirstReadButton();
        acceptAlert("Contato atualizado com sucesso!");
    }

    @Test
    @DisplayName("Should edit the phone number of a contact")
    public void shouldEditThePhoneOfAContact() {
        landingPage.open();
        landingPage.clickAddButton();
        addContactPage.enterName(faker.leagueOfLegends().champion());
        addContactPage.enterPhone(faker.phoneNumber().cellPhone());
        addContactPage.clickCreate();
        acceptAlert("Contato adicionado com sucesso!");
        landingPage.open();
        landingPage.clickConsultButton();
        consultContactPage.clickFirstReadButton();
        WebElement phoneNumberInput = consultContactPage.getFirstContactPhoneInput();
        phoneNumberInput.click();
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone());
        consultContactPage.clickFirstReadButton();
        acceptAlert("Contato atualizado com sucesso!");
    }
}
