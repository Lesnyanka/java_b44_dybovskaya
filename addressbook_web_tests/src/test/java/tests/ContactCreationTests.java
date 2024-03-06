package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void canCreateContact() {

        app.contacts().createContact(new ContactData("", "contact lastname", "contact firstname", "contact address", "contact email", "contact mobile"));
    }

    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>();
        for (var lastname : List.of("", "contact name")) {
            for (var firstname : List.of("", "contact firstname")) {
                for (var address : List.of("", "contact address")) {
                    for (var email : List.of("", "contact email")) {
                        for (var mobile : List.of("", "contact mobile")) {

                            result.add(new ContactData().withLastname(lastname).withFirstname(firstname).withAddress(address).withEmail(email).withMobile(mobile));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            result.add(new ContactData()
                    .withFirstname(randomString(i * 10))
                    .withLastname(randomString(i * 10))
                    .withAddress(randomString(i * 10))
                    .withEmail(randomString(i * 10))
                    .withMobile(randomString(i * 10)));

        }
        return result;

    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contacts().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.add(contact.withId(newContacts.get(newContacts.size() - 1).id()).withLastname("").withFirstname(""));
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts, expectedList);

    }

}
