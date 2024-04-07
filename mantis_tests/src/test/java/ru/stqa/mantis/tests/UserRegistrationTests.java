package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserRegistrationTests extends TestBase{

    @Test

    void canRegisterUser(String username){
        var email = String.format("%s@localhost", username);
        //создать пользователя (адрес) на почтовом сервере(JamesHelper)
        app.jamesCli().addUser("user2@localhost", "password");
        //заполняем форму создания и отправляем(браузер)


        //ждем почту(MailHelper)
        app.mail().receive();
        //извлечь ссылку из письма

        //проходим по ссылке и завершаем регистрацию пользователя(браузер)
        //проверка, что пользователь может залогиниться(HttpSessionHelper)
        Assertions.assertTrue();

    }
}
