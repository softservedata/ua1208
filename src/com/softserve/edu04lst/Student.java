package com.softserve.edu04lst;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    public static class ByDestName implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            return -student1.getName().compareTo(student2.getName());
        }
    }

    public static class ByNameAndId implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            int result = student1.getName().compareTo(student2.getName());
            return result == 0 ? student1.getId() - student2.getId() : result;
        }
    }

    // - - - - - - - - - -

    private int id;
    private  String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n\tStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        return getName().compareTo(student.getName());
        //return getId() - student.getId();
    }
}
