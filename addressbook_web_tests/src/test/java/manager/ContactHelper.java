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
        returnToHomePage();
    }

    private void openContactPage()  {
        click(By.linkText("add new"));
    }

    private void fillContactForm(ContactData contact) {
        type(By.name("contact_lname"), contact.lname());
        type(By.name("contact_fname"), contact.fname());
        type(By.name("contact_address"), contact.address());
        type(By.name("contact_email"), contact.email());
        type(By.name("contact_phone"), contact.phone());
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }





    //private void initContactCreation() {
    //click(By.name("add new"));
    //}



    public boolean isContactPresent() {
        openContactPage();
        return manager.isElementPresent(By.name("selected[]"));
    }
}
