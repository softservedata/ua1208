package com.softserve.yevhenKatruk.hw13.data;

import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;

public class LoginDataRepository {
    public static Stream<Arguments> getInvalidLoginData() {
        return Stream.of(
                Arguments.of(new LoginData("invalidemailgreencity.com", "invalidpass", "Please check if the email is written correctly", "Bad email or password")),
                Arguments.of(new LoginData("somewrongemailexample.com", "invalidpass", "Please check if the email is written correctly", "Bad email or password"))
        );
    }

    public static Stream<Arguments> getValidLoginData() {
        return Stream.of(
                Arguments.of(new LoginData("tyv09754@zslsz.com", "Qwerty_1", null, null))
        );
    }
}
