package edu.softserve.edu.hw13.pages;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;


public class SignInDataRepository {

    public static Stream<Arguments> provideValidSignInData() {
        return Stream.of(
                Arguments.of(new SignInData("svetlana.babyuk1@gmail.com", "Vjqvbh2011//")),
                Arguments.of(new SignInData("another.valid.email@example.com", "anotherValidPassword"))
        );
    }

    public static Stream<Arguments> provideInvalidSignInData() {
        return Stream.of(
                Arguments.of(new SignInData("svetlana.babyuk1gmail.com", "bh2011//")),
                Arguments.of(new SignInData("invalid.email@", "wrongPassword//"))
        );
    }
}
