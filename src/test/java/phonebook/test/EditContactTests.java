package phonebook.test;

import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
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
}
