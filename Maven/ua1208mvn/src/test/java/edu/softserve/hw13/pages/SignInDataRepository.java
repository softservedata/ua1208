package edu.softserve.hw13.pages;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;


public class SignInDataRepository {

    public static Stream<Arguments> provideInvalidSignInData() {
        return Stream.of(
                Arguments.of(new SignInData("invalidemailgreencity.com", "invalidpass",
                        "Перевірте коректність введеної електронної адреси", "Bad email or password"))        );
    }

    public static Stream<Arguments>provideValidSignInData() {
        return Stream.of(
                Arguments.of(new SignInData("svetlana.babyuk1@gmail.com", "Vjqvbh2011//", null, null))
        );
    }

    public static class SignInData {
        private String email;
        private String password;
        private String emailErrorMessage;
        private String passwordErrorMessage;

        public SignInData(String email, String password, String emailErrorMessage, String passwordErrorMessage) {
            this.email = email;
            this.password = password;
            this.emailErrorMessage=emailErrorMessage;
            this.passwordErrorMessage=passwordErrorMessage;

        }

        public String getEmail() {

            return email;
        }

        public String getPassword() {

            return password;
        }

        public String getEmailErrorMessage() {

            return emailErrorMessage;
        }
        public String getPasswordErrorMessage(){

            return passwordErrorMessage;
        }
    }
}
