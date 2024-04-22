package ru.stqa.mantis.tests;

import common.CommonFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.stream.Stream;


public class UserRegistrationTests extends TestBase{


    private Duration duration;
    public static Stream<String> randomUser(){
        return Stream.of(CommonFunctions.randomString(8));
    }

    @ParameterizedTest
    @MethodSource("randomUser")

    void canRegisterUser(String username){
        //создать пользователя (адрес) на почтовом сервере(JamesHelper)
        var email = String.format("user3@localhost", username);
        var password = "password";
        app.jamesCli().addUser("user3@localhost", "password");
        app.session().login("administrator", "root");
        //заполняем форму создания и отправляем(браузер)
        var user = new UserData("username", "username", "user3@localhost");
        app.user().startCreations(user);
        //ждем почту(MailHelper)
        app.mail().receive("user3@localhost", "password", Duration.ofSeconds(60));
        //извлечь ссылку из письма
        var messages = app.mail().receive("user3@localhost", "password", Duration.ofSeconds(60));
        var url = CommonFunctions.extractUrl(messages.get(0).content());
        //проходим по ссылке и завершаем регистрацию пользователя(браузер)
        app.user().finishCreation(url, password);
        //проверка, что пользователь может залогиниться(HttpSessionHelper)
        Assertions.assertTrue(app.http().isLoggedIn());

    }
}
