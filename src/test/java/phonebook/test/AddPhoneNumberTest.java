package phonebook.test;

import org.junit.*;
import org.junit.jupiter.api.DisplayName;
import phonebook.test.pages.AddContactPage;
import phonebook.test.pages.LandingPage;

public class AddPhoneNumberTest extends BaseTest {
    private LandingPage landingPage;
    private AddContactPage addContactPage;

    @Before
    public void setUp() {
        super.setUp();
        landingPage = new LandingPage(driver);
        addContactPage = new AddContactPage(driver);
    }

    @Test
    @DisplayName("Should add contact if phonenumber and name are valid")
    public void shouldAddContactIfPhoneNumberAndNameAreValid() {
        landingPage.open();
        landingPage.clickAddButton();
        addContactPage.enterName(faker.leagueOfLegends().champion());
        addContactPage.enterPhone(faker.phoneNumber().cellPhone());
        addContactPage.clickCreate();
        acceptAlert("Contato adicionado com sucesso!");
    }
}
