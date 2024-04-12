package ru.stqa.mantis.tests;

import common.CommonFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;

public class UserRegistrationTests extends TestBase{


    private Duration duration;

    @Test

    void canRegisterUser(String username){
        //создать пользователя (адрес) на почтовом сервере(JamesHelper)
        var email = String.format("%s@localhost", username);
        var password = "password";
        app.jamesCli().addUser("user3@localhost", "password");
        app.mail().drain(username, password);
        //заполняем форму создания и отправляем(браузер)
        //app.user().startCreations(user);
        //ждем почту(MailHelper)
        app.mail().receive(username, password, duration);
        //извлечь ссылку из письма
        //var url = CommonFunctions.extractUrl(messages.get(0).content());
        //проходим по ссылке и завершаем регистрацию пользователя(браузер)
        //app.user().finishCreation(url, password);
        //проверка, что пользователь может залогиниться(HttpSessionHelper)
        Assertions.assertTrue(app.http().isLoggedIn());

    }
}
