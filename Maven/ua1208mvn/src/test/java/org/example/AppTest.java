package org.example;

import junit.framework.Assert;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AppTest{
    @Test
    public void ChekTst() {
        double expected;
        double actual;
        expected=5.0001;
        actual=2+3;
        Assert Assertion;
        Assertions.assertEquals(expected,actual, 0.001);

    }


}
