package com.softserve.edu.javapr2.les.pr04List;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    public static class ByDestName implements Comparator<Student> {
        public int compare(Student student, Student student2) {
            return - student.getName().compareTo(student2.getName());


        }
    }
    public static class ByNameAndID implements Comparator<Student> {
        public int compare(Student student, Student student2) {
            int result = student.getName().compareTo(student2.getName());
            return result == 0 ? student.getId()-student2.getId() : result;

        }
    }


    //----------------------------------------
    private int id;
    private String name;

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
        return "\n \t Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Student student) {
        return getName().compareTo(student.getName());
        //return getId() - student.getId();
    }
}
