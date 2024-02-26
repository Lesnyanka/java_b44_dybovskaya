package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData("contact Last_name", "contact_First_name", "contact_Address", "contact_email", "contact_phone"));
        }
        app.groups().removeGroup();

    }
}
