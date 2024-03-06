package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import java.util.List;
import java.util.ArrayList;


public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openHomePage();
        initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        openHomePage();
    }

    public void modifyContact(ContactData contact, ContactData modifedContact) {
        openHomePage();
        selectContact(contact);
        initContactModification();
        fillContactForm(modifedContact);
        submitContactModification();
        returnToHomePage();
    }

    private void returnToHomePage()  {
        click(By.linkText("add new"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification()  {
        click(By.cssSelector("img[title=Edit]"));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContacts();

    }

    private void openContactPage() {
        click(By.linkText("add new"));
    }
    private void submitContactCreation() {
        click(By.name("submit"));
    }
    private void removeSelectedContacts() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]"));
    }
    private void fillContactForm(ContactData contact) {
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile());
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value='%s']", contact.id())));

    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }








    private void openHomePage() {
        click(By.linkText("home"));
    }


    private void initContactCreation() {
    click(By.name("add new"));
    }





    public int getCount() {
        openHomePage();
        selectAllContacts();
        return manager.driver.findElements(By.name("selected[]")).size();
   }

    public void removeAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContacts();
    }

    private void selectAllContacts() {
        openHomePage();
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }



    public  List<ContactData> getContactList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var tds = manager.driver.findElements(By.cssSelector("td.center"));
        for (var td : tds) {
            var lastname = td.getText();
            var firstname = td.getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname));

        }

        return contacts;
    }
}
