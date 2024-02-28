package manager;

import model.ContactData;
import org.openqa.selenium.By;


public class ContactHelper extends HelperBase {
    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
        //initContactCreation();
        fillContactForm(contact);
        submitContactCreation();
        openHomePage();
    }

    private void openContactPage()  {
        click(By.linkText("add new"));
    }

    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("lastname"), contact.lastname());
        type(By.name("firstname"), contact.firstname());
        type(By.name("address"), contact.address());
        type(By.name("email"), contact.email());
        type(By.name("mobile"), contact.mobile());
    }

    public void removeContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
        openHomePage();
    }



    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void openHomePage() {
        click(By.linkText("home"));
    }





    //private void initContactCreation() {
    //click(By.name("add new"));
    //}







    private void selectContact() {
        click(By.name("selected[]"));

    }

    private void removeSelectedContact()  {
        click(By.xpath("//div[@id='content']/form[2]/div[2]"));
    }

}
