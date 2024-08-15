package com.softserve.edu06set;

import java.util.Comparator;
import java.util.Objects;

public class Employee implements Comparable<Employee> {

    public static class ByNameAndId implements Comparator<Employee> {
        @Override
        public int compare(Employee employee0, Employee employee1) {
            if (employee0 == null && employee1 == null) {
                return 0;
            } else if (employee0 == null) {
                return -1;
            } else if (employee1 == null){
                return 1;
            }
            return employee0.getId() - employee1.getId();
        }
    }

    // ----------

    private int id;
    private String name;

    public Employee(int id, String name) {
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
    public boolean equals(Object o) {
        //System.out.println("\t\tequals first = " + this + "  second = " + o);
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        //System.out.println("\t\thashCode from = " + this);
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "\n\tEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Employee employee) {
        //return getName().compareTo(employee.getName());
        return getId() - employee.getId();
    }
}
