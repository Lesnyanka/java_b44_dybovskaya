package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.group;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount()==0) {
            app.hbm().createContact(new ContactData("", "contact lastname","contact firstname", "contact address", "contact email", "contact mobile"));
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        assertEquals(newContacts, expectedList);
    }

    @Test
    void canRemovalContactsAtOnce() {
        if (app.hbm().getContactCount() == 0){
            app.hbm().createContact(new ContactData("", "contact lastname","contact firstname", "contact address", "contact email", "contact mobile"));
        };
        app.contacts().removeAllContacts();
        assertEquals(0, app.hbm().getContactCount());

    }

    @Test
    void canRemovalContactFromGroup(){
        var contact = app.hbm().getContactList();
        var oldRelated = app.hbm().getContactsInGroup(group);
        if (contact.size() == oldRelated.size()) {
            app.hbm().getContactsInGroup(new GroupData("", "group name", "group header", "group footer"));}
        }else if(contact.size() != oldRelated.size()) {
        app.contacts().removeContactFromGroup(contact, group);
    }
}
