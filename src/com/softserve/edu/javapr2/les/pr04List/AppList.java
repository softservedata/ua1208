package com.softserve.edu.javapr2.les.pr04List;

import java.util.*;

public class AppList {
    public static void main(String[] args) {
        String[] arrStr = {"222", "1", "1111", "10"};
        System.out.println("arrStr = " + Arrays.toString(arrStr));

        // Створюємо Ліст від масиву
        List<String> lstStr = Arrays.asList(arrStr);
        System.out.println("lstStr = " + lstStr);
        arrStr[1] = "001";
        lstStr.set(2, "aa");
        System.out.println("Changed lstStr = " + lstStr);
        Collections.sort(lstStr);
        System.out.println("Sort lstStr = " + lstStr);

        //Створюємо повноцінний ліст з масиву
        List<String> lstStr2 = new ArrayList<>(Arrays.asList(arrStr));
        lstStr2.add(1, "add2222"); //додаємо значення на 1 позицію
        lstStr2.add("add001");//додається значення
        lstStr2.add("add111");
        lstStr2.add("add010");
        System.out.println("Original: lstSrt2 = " + lstStr2);
        Collections.sort(lstStr2);
        System.out.println("Sorted lstStr2 = " + lstStr2);
        lstStr2.clear();
        System.out.println("strStr.clear() = " + lstStr2);

        List<Student> lstStr1 = new ArrayList<>();
        lstStr1.add(new Student(232, "Petro"));
        lstStr1.add(new Student(143, "Stepan"));
        lstStr1.add(new Student(234, "Petro"));
        lstStr1.add(new Student(567, "Ira"));
        lstStr1.add(new Student(123, "Ivan"));
        lstStr1.add(new Student(233, "Petro"));
        System.out.println("Original: lstStr1 = " + lstStr1);

        List<Student> lstStr3 = List.of(new Student(232, "Petro"),
                new Student(143, "Stepan"),
                new Student(234, "Petro"),
                new Student(567, "Ira"),
                new Student(123, "Ivan"),
                new Student(233, "Petro")
        );
        System.out.println("lstStr3 type = " + lstStr3.getClass().getName());
        List<Student> lstSrt1 = new ArrayList<>(lstStr3);
        System.out.println("Original lstStr3 "+ lstStr3);
        lstSrt1.sort(new Student.ByNameAndID());
        //Collections.sort(lstStr1);
        System.out.println("\n Sorted lstStr1 = "+ lstStr1);

    }
}
