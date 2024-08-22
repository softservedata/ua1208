package com.softserve.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class CalcSecondTest {
    public static final double DELTA =  0.001;
    public static Calc calc;

    @BeforeAll
    public static void setup() {
        calc = new Calc();
    }

    @DisplayName("Should pass a non-null message to our test method")
    @ParameterizedTest
    @ValueSource(strings = {"Hello", "World"})
    void shouldPassNonNullMessageAsMethodParameter(String message) {
        System.out.println("Message = " + message);
        Assertions.assertNotNull(message);
    }

    //@Test
    @DisplayName("Should calculate the correct sum")
    @ParameterizedTest(name = "{index} => arg0={0}, arg1={1}, expected={2}")
    @CsvSource({
            "2, 2, 4",
            "2, 3, 5"
    })
    public void checkAdd(double arg0, double arg1, double expected) {
        //Calc calc = new Calc();
        //double expected;
        double actual;
        //
        //expected = 4;
        actual = calc.add(arg0, arg1);
        Assertions.assertEquals(expected, actual, DELTA);
    }

    // DataProvider
    private static Stream<Arguments> divProvider() {
        return Stream.of(
                Arguments.of(20, 5, 4),
                Arguments.of(20, 8, 2.5)
        );
    }

    //@Test
    @DisplayName("Should calculate the correct div")
    @ParameterizedTest(name = "{index} => arg0={0}, arg1={1}, expected={2}")
    @MethodSource("divProvider")
    public void checkDiv(double arg0, double arg1, double expected) {
        //Calc calc = new Calc();
        //double expected;
        double actual;
        //
        //expected = 5;
        actual = calc.div(arg0, arg1);
        Assertions.assertEquals(expected, actual, DELTA);
    }
}
