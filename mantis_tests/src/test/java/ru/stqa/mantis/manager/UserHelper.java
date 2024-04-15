package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.model.UserData;

public class UserHelper extends HelperBase{
    public UserHelper(ApplicationManager manager){
        super(manager);
    }


    public void startCreations( UserData user) {
        openManagePage();
        clickUsersPage();
        createNewAccount();
        fillUserForm(user);
        pushCreateUser();

    }

    private void clickUsersPage() {
        click(By.xpath("//a[normalize-space()='Users']"));
    }

    private void pushCreateUser() {
        click(By.xpath("//input[@value='Create User']"));
    }

    private void fillUserForm(UserData user) {
        type(By.name("username"), user.username());
        type(By.name("realname"), user.realname());
        type(By.name("email"), user.email());
    }

    private void createNewAccount() {
        click(By.xpath("(//a[normalize-space()='Create New Account'])[1]"));
    }

    private void openManagePage() {
        click(By.xpath("(//a)[14]"));
    }

    public void finishCreation(Object url, String password) {

    }


}
