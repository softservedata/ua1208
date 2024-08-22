package com.softserve.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;

public class MyArrayTest {
    public static MyArray marr;

    @BeforeAll
    public static void setup() {
        marr = new MyArray();
    }

    //@Order(1)
    @Test
    public void checkLen() {
        int[] actual = marr.createArr();
        Assertions.assertEquals(5, actual.length);
    }

    //@Order(22) // TODO
    @Test
    public void checkArr() {
        int[] expected = {1, 2, 3, 5, 4};
        Arrays.sort(expected);
        int[] actual = marr.createArr();
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Object[] arrProvider() {
        return new Object[] {
                new int[]{1, 2, 3, 4, 5},
                new int[]{1, 2, 3, 5, 4}
        };
    }

    @ParameterizedTest
    @MethodSource("arrProvider")
    public void checkArr2(int[] expected) {
        Arrays.sort(expected);
        int[] actual = marr.createArr();
        Assertions.assertArrayEquals(expected, actual);
    }

    private static Object[][] arr2Provider() {
        return new Object[][] {
                { new int[]{1, 2, 3, 4, 5}, 2},
                { new int[]{1, 2, 3, 5, 4}, 5}
        };
    }

    @ParameterizedTest
    @MethodSource("arr2Provider")
    public void checkExist(int[] actual, int number) {
        Assertions.assertTrue(marr.isContains(actual, number));
    }
}
