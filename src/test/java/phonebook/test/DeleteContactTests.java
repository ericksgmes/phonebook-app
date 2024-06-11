package phonebook.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
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
        landingPage.clickAddButton();
        addContactPage.enterName(faker.name().fullName());
        addContactPage.enterPhone(faker.phoneNumber().cellPhone());
        addContactPage.clickCreate();
        acceptAlert("Contato adicionado com sucesso!");
        landingPage.open();
        landingPage.clickConsultButton();
        consultContactPage.clickFirstDeleteButton();
        acceptAlert("Tem certeza de que deseja excluir este contato?");
        acceptAlert("Contato excluído com sucesso!");
    }
}
