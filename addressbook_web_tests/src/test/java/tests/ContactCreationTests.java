package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import common.CommonFunctions;
import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
     void canCreateContact() {

        var contact = new ContactData()
                .withLastname(CommonFunctions.randomString(10))
                .withFirstname(CommonFunctions.randomString(10))
                .withAddress(CommonFunctions.randomString(10))
                .withEmail(CommonFunctions.randomString(10))
                .withMobile(CommonFunctions.randomString(10));
        app.contacts().createContact(contact);
    }

    public static List<ContactData> contactProvider() throws IOException {
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
        var json = "";
        try(var reader = new FileReader("contacts.xml");
            var breader = new BufferedReader(reader)
        ){
            var line = breader.readLine();
            while (line != null){
                json = json + line;
                line = breader.readLine();
            }

        }
        //var json = Files.readString(Paths.get("groups.json"));
        var mapper = new XmlMapper();
        var value = mapper.readValue(new File("contacts.xml"), new TypeReference<List<ContactData>>(){});
        result.addAll(value);
        return result;

    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContact(ContactData contact) {
        var oldContacts = app.contacts().getList();
        app.contacts().createContact(contact);
        var newContacts = app.contacts().getList();
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
