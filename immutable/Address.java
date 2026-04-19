package immutable;

public class Address implements Cloneable {
    private int pinCode;
    private String street;

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}