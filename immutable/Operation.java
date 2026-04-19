package immutable;

import java.util.Date;
import java.util.HashMap;

public class Operation {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("check it");
        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value1");
        Address address = new Address();
        address.setPinCode(246723);
        address.setStreet("main");
        Date date = new Date();
        Student student = new Student(1, "vipul", map, address, date);
        Address address1 = student.getAddress();
        address1.setStreet("vipul");
        System.out.println(student.getAddress().getStreet());
        System.out.println(student.getDate());
        Date d2 = student.getDate();
        // d2.setYear(2000);
        d2.setDate(
                1);
        System.out.println(d2);
        System.out.println(student.getDate());
    }
}

