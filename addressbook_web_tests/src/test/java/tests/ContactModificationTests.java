package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class ContactModificationTests extends TestBase{
    @Test
    void canModifyContact(){
        if (app.contacts().getCount() == 0){
            app.contacts().createContact(new ContactData("", "contact lastname", "contact firstname", "contact address", "contact email", "contact mobile"));
        }
        var oldContacts = app.contacts().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        var testDate = new ContactData().withFirstname("Petrovich firstname");
        app.contacts().modifyContact(oldContacts.get(index), testDate);
        var newContacts = app.contacts().getContactList();
        var expectedList = new ArrayList<>(oldContacts );
        expectedList.set(index, testDate.withId(oldContacts .get(index).id()));
        Comparator<ContactData> compareById = (o1, o2) -> {
            return Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        };
        oldContacts.sort(compareById);
        expectedList.sort(compareById);
        Assertions.assertEquals(newContacts , expectedList);
    }
}
