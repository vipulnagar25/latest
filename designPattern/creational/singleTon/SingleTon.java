package designPattern.creational.singleTon;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * Database connection
 * Logger
 * Configuration manager
 * Cache
 * Thread pool
 * Driver / Device manager
 */
public class SingleTon implements Cloneable, Serializable {
    private static SingleTon INSTANCE = null;
    int variable = 10;

    public SingleTon() {
        if (INSTANCE != null) {
            throw new RuntimeException("Singleton instance already exists!");
        }
    }

    public static SingleTon getInstance() {
        if (INSTANCE == null) { // double  mechanism
            synchronized (SingleTon.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingleTon();
                }
            }
        }
        return INSTANCE;
    }

    public Object clone() throws CloneNotSupportedException {
        // return INSTANCE
        throw new CloneNotSupportedException();
    }

    private Object readResolve() throws ObjectStreamException {
        System.out.println("At the time read object from file");
        return INSTANCE;
    }

    private Object writeReplace() throws ObjectStreamException {
        System.out.println("At the time write object into  file");
        return INSTANCE;
    }

    static void main() {
        SingleTon singleTon = getInstance();
        SingleTon singleTon1 = null;
        // try to break singleton design property
        try {
            Constructor constructor = SingleTon.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            singleTon1 = (SingleTon) constructor.newInstance();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        System.out.println("Hashcode of Object 1 - " + singleTon.hashCode());
        System.out.println("Hashcode of Object 2 - " + singleTon1);
        // by cloning
        /*SingleTon singleTon2= (SingleTon) singleTon.clone();
        System.out.println(singleTon2.hashCode());*/

    }

}