package javaCollection.map;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class Employee {
    int id;
    String name;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode" + Objects.hash(id, name));
        return Objects.hash(id, name);// Simple hash code based on id
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("John", 1);
        Employee e2 = new Employee("Jane", 2);
        Employee e3 = new Employee("John", 1);
        Map<Employee, String> map = new java.util.HashMap<>();
        map.put(e1, "a");
        map.put(e2, "b");
        map.put(e3, "b");
        map.put(null, "b");
        map.put(null, "b");
        System.out.println("+++++++++++++++++++++++++++++=");
        HashSet<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);
    }
}
