package com.softserve.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void checkAdd() {
        double expected;
        double actual;
        //
        expected = 5.0001;
        actual = 2 + 3;
        Assertions.assertEquals(expected, actual, 0.001);
    }
}
