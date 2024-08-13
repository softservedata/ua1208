package com.softserve.edu04lst;

import java.util.*;

public class ApplList {

    public static void main(String[] args) {
        /*-
		String[] arrStr = { "222", "1", "1111", "10" };
		//System.out.println("arrStr = " + arrStr); // toString() from Object;
		System.out.println("arrStr = " + Arrays.toString(arrStr));
		//
		List<String> lstStr = Arrays.asList(arrStr);
		System.out.println("lstStr = " + lstStr); // toString();
		arrStr[1] = "001";
		//lstStr.clear(); // Error
		//lstStr.add("aa"); // Error
		lstStr.set(2,"aa");
		System.out.println("Changed lstStr = " + lstStr);
		//System.out.println("Changed arrStr = " + Arrays.toString(arrStr));
		//Arrays.sort(arrStr);
		Collections.sort(lstStr);
		//lstStr.sort((a,b)->a.compareTo(b));
		System.out.println("Sorted lstStr = " + lstStr);
		*/
		/*-
		String[] arrStr = { "222", "1", "1111", "10" };
		List<String> lstStr = new ArrayList<>(Arrays.asList(arrStr));
		//List<String> lstStr = new ArrayList<>();
		//lstStr.add("0021");
		//lstStr.add("0013");
		lstStr.add(1,"add2222");
		lstStr.add("add001");
		lstStr.add("add1111");
		lstStr.add("add010");
		System.out.println("Original: lstStr = " + lstStr);
		Collections.sort(lstStr);
		System.out.println("Sorted: lstStr = " + lstStr);
		lstStr.clear();
		System.out.println("stStr.clear() = " + lstStr);
		*/
		/*
		List<String> list = new LinkedList<>();
		list.add("First element");  // Adding elements
		list.add("Second element");
		list.add("Third element");
		list.add("Fourth element");
		System.out.println("Original: list = " + list);
		list.set(0, "One more first element"); // insert at position 0
		System.out.println("Updated: list = " + list);
		*/
		/*-
		List<Student> lstStr = new ArrayList<>();
		lstStr.add(new Student(232, "Petro"));
		lstStr.add(new Student(143, "Stepan"));
		lstStr.add(new Student(234, "Petro"));
		lstStr.add(new Student(567, "Ira"));
		lstStr.add(new Student(123, "Ivan"));
		lstStr.add(new Student(233, "Petro"));
		System.out.println("Original: lstStr = " + lstStr);
		*/
		/*
		List<Student> lstStr1 = List.of(new Student(232, "Petro"),
				new Student(143, "Stepan"),
				new Student(234, "Petro"),
				new Student(567, "Ira"),
				new Student(123, "Ivan"),
				new Student(233, "Petro")
				);
		System.out.println("lstStr1 type = " + lstStr1.getClass().getName());
		List<Student> lstStr = new ArrayList<>(lstStr1);
		System.out.println("\nOriginal: lstStr = " + lstStr);
		//
		//lstStr.sort(new Student.ByNameAndId());
		//Collections.sort(lstStr);
		//Collections.sort(lstStr, new Student.ByDestName());
		Collections.sort(lstStr, new Student.ByNameAndId());
		System.out.println("\nSorted: lstStr = " + lstStr);
		//
		Student st1 = new Student(145, "Stepan");
		lstStr.add(1, st1);
		System.out.println("\nUpdated: lstStr = " + lstStr);
		System.out.println("Element from 1 position: " + lstStr.get(1));
		*/
		//
		List<String> list = new ArrayList<>();
		List<String> addList = List.of("add First", "add Second");
		list.add("First element");
		list.add("Second element");
		list.add("Third element");
		list.add("Fourth element");
		list.add(0, "One more first element");
		list.addAll(2, addList);
		System.out.println("list = " + list);
		//
		//List<String> removeElements = List.of("First element", "Fourth element");
		//list.removeAll(removeElements);
		List<String> retainElements = List.of("First element", "Fourth element");
		list.retainAll(retainElements);
		System.out.println("list = " + list);

	}
}
