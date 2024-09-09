package com.softserve.edu.hw08;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrTest {
    private String[] arr0 = {"a", "c", "b", "d"};
    private String[] arr1 = {"c", "a", "d", "b"};

    @Test
    public void chackArr() {
        Arrays.sort(arr0);//сортування масивів відбувається досить довго
        Arrays.sort(arr1);
        Assert.assertArrayEquals(arr0, arr1);// порівняння масивів
    }

    @Test
    public void chackSet() {
        Set<String> set0 = new HashSet<>(Arrays.asList(arr0));
        Set<String> set1 = new HashSet<>(Arrays.asList(arr1));
        Assert.assertTrue(set0.equals(set1));// порівняння масивів
    }
}
