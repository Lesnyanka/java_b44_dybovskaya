package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
        @Test
        public void canCreateContact() {

                app.contacts().createContact(new ContactData("contact lastname", "contact firstname", "contact address", "contact email", "contact mobile"));
        }

}
