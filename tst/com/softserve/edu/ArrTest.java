package com.softserve.edu;

import org.junit.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrTest {
    private String[] arr0 = {"a", "c", "b", "d"};
    private String[] arr1 = {"c", "a", "d", "b"};


    @Test
    public void checkArr() {
        Arrays.sort(arr0);
        Arrays.sort(arr1);
        Assert.assertArrayEquals(arr0, arr1);
    }

    @Test
    public void checkSet() {
        Set<String> set0 = new HashSet<>(Arrays.asList(arr0));
        Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        Assert.assertTrue(set0.equals(set1));
    }
}
