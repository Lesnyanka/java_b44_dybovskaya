package ru.stqa.mantis.manager;

import org.openqa.selenium.By;
import ru.stqa.mantis.model.UserData;

public class UserHelper extends HelperBase{
    public UserHelper(ApplicationManager manager){
        super(manager);
    }


    public void startCreations( UserData user) {
        openRegistrationsPage();
        createNewAccount();
        fillUserForm(user);
        pushCreateUser();

    }

    private void pushCreateUser() {
        click(By.linkText("Create User"));
    }

    private void fillUserForm(UserData user) {
        type(By.name("username"), user.username());
        type(By.name("realname"), user.realname());
        type(By.name("email"), user.email());
    }

    private void createNewAccount() {
        click(By.linkText("Create New Account"));
    }

    private void openRegistrationsPage() {
        click(By.linkText("manage_user_page"));
    }

    public void finishCreation(Object url, String password) {

    }


}
