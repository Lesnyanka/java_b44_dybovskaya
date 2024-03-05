package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void canCreateContact() {

        app.contacts().createContact(new ContactData("contact lastname", "contact firstname", "contact address", "contact email", "contact mobile"));
    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var lastname : List.of("", "contact name")) {
            for (var firstname : List.of("", "contact firstname")) {
                for (var address : List.of("", "contact address")) {
                    for (var email : List.of("", "contact email")) {
                        for (var mobile : List.of("", "contact mobile")) {

                            result.add(new ContactData(lastname, firstname, address, email, mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10), randomString(i * 10)));

        }
        return result;

    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        int n = 5;
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newcontactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newcontactCount);
    }

}
