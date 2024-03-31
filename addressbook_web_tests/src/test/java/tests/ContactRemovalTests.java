package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

//import  jdk.nio.zipfs.ZipFileAttributeView.AttrID.group;
import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.group;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactRemovalTests extends TestBase {

    @Test
    public void canRemoveContact() {
        if (app.hbm().getContactCount()==0) {
            app.hbm().createContact(new ContactData("", "contact lastname","contact firstname", "contact address", "contact email", "contact mobile", "", "", ""));
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
            app.hbm().createContact(new ContactData("", "contact lastname","contact firstname", "contact address", "contact email", "contact mobile", "", "", ""));
        };
        app.contacts().removeAllContacts();
        assertEquals(0, app.hbm().getContactCount());

    }

    @Test
    void canRemovalContactFromGroup(){
        if (app.hbm().getContactCount() == 0){
            app.hbm().createContact(new ContactData("", "contact lastname","contact firstname", "contact address", "contact email", "contact mobile", "", "", ""));
        };
        if (app.hbm().getGroupCount() == 0){
            app.hbm().createGroup(new GroupData("", "group name", "group header", "group footer"));
        };
        //if (app.hbm().getContactsInGroup(group) == 0) {
            app.contacts().createContactInGroupThroughHomePage(new ContactData("", "contact lastname","contact firstname", "contact address", "contact email", "contact mobile", "", "", "" ), new GroupData("", "group name", "group header", "group footer"));
        };
       // var oldRelated = app.hbm().getContactsInGroup(group);
       // app.contacts().removeContactFromGroup(contact, group);
       // var newRelated = app.hbm().getContactsInGroup(group);
        //Assertions.assertEquals(oldRelated.size() - 1, newRelated.size());
    }
}
