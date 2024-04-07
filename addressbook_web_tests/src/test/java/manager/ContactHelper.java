package manager;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    public void create(ContactData contact, GroupData group) {
        openHomePage();
        initContactCreation();
        fillContactForm(contact);
        selectGroup(group);
        submitContactCreation();
        openHomePage();
    }

    public void createContactInGroupThroughHomePage(ContactData contact, GroupData group) {
        openHomePage();
        selectContact(contact);
        selectGroupInList(group);
        selectAddButton();
        returnToHomePage();
    }

    private void selectGroupInList(GroupData group) {
        new Select(manager.driver.findElement(By.name("to_group"))).selectByValue(group.id());
    }
    private void selectAddButton() {
        click(By.name("add"));
    }


    private void selectGroup(GroupData group) {
       new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroupUi(GroupData group) {
        click(By.xpath(String.format("//select[@name='group']//option[@value='%s']",group.id())));
    }

    public void modifyContact(ContactData contact, ContactData modifiedContact) {
        openHomePage();
        selectContact(contact);
        initContactModification(contact);
        fillContactForm(modifiedContact);
        submitContactModification();
        returnToHomePage();
    }

    private void returnToHomePage()  {
        click(By.linkText("add new"));
    }

    private void submitContactModification() {
        click(By.name("update"));
    }

    private void initContactModification(ContactData contact)  {
        click(By.xpath(String.format("//a[@href='edit.php?id=%s']", contact.id())));
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
        click(By.xpath(String.format("//input[@id ='%s']", contact.id())));
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }








    private void openHomePage() {
        click(By.linkText("home"));
    }


    private void initContactCreation() {
    click(By.linkText("add new"));
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

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroupWithContacts(group);
        selectContact(contact);
        //selectAllContacts();
        selectRemoveButton();
    }

    private void selectRemoveButton() {
        click(By.name("remove"));
    }

    private void selectGroupWithContacts(GroupData group) {
        click(By.name("group"));
        selectGroupUi(group);

    }

    private void selectAllContacts() {
        openHomePage();
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes){
            checkbox.click();
        }
    }



    public  List<ContactData> getList() {
        openHomePage();

        var contacts = new ArrayList<ContactData>();
        var cell = manager.driver.findElements(By.name("entry"));
        for (var td : cell) {
            var lastname = td.findElement(By.xpath(".//td[2]")).getText();
            var firstname = td.findElement(By.xpath(".//td[3]")).getText();
            var checkbox = td.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");

            contacts.add(new ContactData().withId(id).withLastname(lastname).withFirstname(firstname));
        }

        return contacts;
    }

    public String getPhones(ContactData contact) {
       return manager.driver.findElement(By.xpath(
               String.format("input[value='%s']//..//..td[6]", contact.id()))).getText();

    }

    public Map<String, String> getPhones() {
        var result = new HashMap<String, String>();
                List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for(WebElement row : rows){
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var phones = row.findElements(By.tagName("td")).get(5).getText();
            result.put(id, phones);
        }
        return result;
    }

    public Map<String, String> getAddress() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for(WebElement row : rows){
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var address = row.findElements(By.tagName("td")).get(3).getText();
            result.put(id, address);
        }
        return result;
    }

    public Map<String, String> getEmails() {
        var result = new HashMap<String, String>();
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for(WebElement row : rows){
            var id = row.findElement(By.tagName("input")).getAttribute("id");
            var emails = row.findElements(By.tagName("td")).get(4).getText();
            result.put(id, emails);
        }
        return result;
    }
}
