package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {
        @Test
        public void canCreateContact() {

                app.contacts().createContact(new ContactData("contact_lname", "contact_fname", "contact_address", "contact_email", "contact_phone"));
        }

}
