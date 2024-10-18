package com.softserve.edu.javapr2.les.pr04List;

import java.util.*;

public class AppList {
    public static void main(String[] args) {
        String [] arrStr = {"222" , "1", "1111","10"};
        System.out.println("arrStr = "+ Arrays.toString(arrStr));

        // Створюємо Ліст від масиву
        List<String> lstStr = Arrays.asList(arrStr);
        System.out.println("lstStr = " + lstStr);
        arrStr[1]="001";
        lstStr.set(2, "aa");
        System.out.println("Changed lstStr = " + lstStr);
        Collections.sort(lstStr);
        System.out.println("Sort lstStr = " + lstStr);

        //Створюємо повноцінний ліст з масиву
        List<String> lstStr2 = new ArrayList<>(Arrays.asList(arrStr));
        lstStr2.add(1,"add2222"); //додаємо значення на 1 позицію
        lstStr2.add("add001");//додається значення
        lstStr2.add("add111");
        lstStr2.add("add010");
        System.out.println("Original: lstSrt2 = " +lstStr2);
        Collections.sort(lstStr2);
        System.out.println("Sorted lstStr2 = "+ lstStr2);
        lstStr2.clear();
        System.out.println("strStr.clear() = " + lstStr2);
    }
}
