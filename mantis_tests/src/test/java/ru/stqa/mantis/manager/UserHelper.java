package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.model.UserData;

public class UserHelper extends HelperBase{
    public UserHelper(ApplicationManager manager){
        super(manager);
    }


    public void startCreations( UserData username) {
        openManagePage();
        clickUsersPage();
        createNewAccount();
        fillUserForm(username);
        pushCreateUser();

    }

    private void clickUsersPage() {
        click(By.xpath("//a[normalize-space()='Users']"));
    }

    private void pushCreateUser() {
        click(By.xpath("//input[@value='Create User']"));
    }

    private void fillUserForm(UserData username) {
        type(By.name("username"), username.username());
        type(By.name("realname"), username.realname());
        type(By.name("user3@localhost"), username.email());
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
