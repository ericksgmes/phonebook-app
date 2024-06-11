package phonebook.test;


import org.junit.Before;
import org.junit.jupiter.api.Test;
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
}
