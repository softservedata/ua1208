package com.softserve.edu06set;

import java.util.Objects;

public class Employee {
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
        //System.out.println("equals first = " + this + "  second = " + o);
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        //System.out.println("hashCode from = " + this);
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "\n\tEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
