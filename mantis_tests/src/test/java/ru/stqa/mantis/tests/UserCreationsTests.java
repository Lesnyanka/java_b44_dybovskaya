package ru.stqa.mantis.tests;

import common.CommonFunctions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.stream.Stream;

public class UserCreationsTests extends TestBase{
    public static Stream<String> randomUser(){
        return Stream.of(CommonFunctions.randomString(8));
    }

    @ParameterizedTest
    @MethodSource("randomUser")
    void canCreateUser(UserData user){
        var email = String.format("%s@localhost", user);
        //создать пользователя (адрес) на почтовом сервере(JamesHelper)
        var password = "password";
        app.jamesApi().addUser("user2@localhost", "password");
        app.user().startCreations(user);
        var messages = app.mail().receive(email, password, Duration.ofSeconds(10));
        var url = CommonFunctions.extractUrl(messages.get(0).content());
        app.user().finishCreation(url, password);
        app.http().login(String.valueOf(user), password);
        Assertions.assertTrue(app.http().isLoggedIn());

    }

}
