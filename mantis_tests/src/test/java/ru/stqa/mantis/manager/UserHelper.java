package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class UserHelper extends HelperBase{
    public UserHelper(ApplicationManager manager){
        super(manager);
    }


    public void fillFormRegistration(UserData user) {
         {
            type(By.name("lastname"), contact.lastname());
            type(By.name("firstname"), contact.firstname());
            type(By.name("address"), contact.address());
            type(By.name("email"), contact.email());
            type(By.name("mobile"), contact.mobile());
    }
}
