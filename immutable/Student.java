package immutable;

import java.util.Date;
import java.util.HashMap;

public final class Student {

    private final String name;
    private final HashMap<String, String> map;
    private final int stuId;
    private final Address address;
    private final Date date;


    public Date getDate() {
        return (Date) date.clone();
    }


    public String getName() {
        return name;
    }

    public HashMap<String, String> getMap() {
        return (HashMap<String, String>) map.clone();
    }

    public int getStuId() {
        return stuId;
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    public Student(int stuId, String name, HashMap<String, String> map, Address address, Date date) {
        this.stuId = stuId;
        this.name = name;
        this.map = map;
        this.address = address;
        this.date = date;
        System.out.println("Student setup done");
    }
}