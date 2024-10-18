package com.softserve.edu.javapr2.les;

import java.util.Objects;

public class Student {
    private String name;
    private int age;

    private static int count = 0;//константа

    public Student() {
        name = "Ivan";
        age = 20;
        count++;
    }

    //Створюємо 3 різні методи для відображення різних варіантів відображення полів
    public Student(String name) {
        this.name = name;
        age = 20;
        count++;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static int getCount() {
        return count;
    }

    @Override // Override - означає, що ми перезаписуємо метод toString
    public String toString() {
        return "Student{" +
                "name = '" + name + '\'' +
                ", age = " + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
