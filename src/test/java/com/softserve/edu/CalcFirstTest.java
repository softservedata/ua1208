package com.softserve.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcFirstTest {

    @Test
    public void checkAdd1() {
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 4;
        actual = calc.add(2, 2);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void checkAdd2() {
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 5;
        actual = calc.add(2, 3);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void checkDiv1() {
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 5;
        actual = calc.div(20, 4);
        Assertions.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void checkDiv2() {
        Calc calc = new Calc();
        double expected;
        double actual;
        //
        expected = 2.5;
        actual = calc.div(20, 8);
        Assertions.assertEquals(expected, actual, 0.001);
    }
}
