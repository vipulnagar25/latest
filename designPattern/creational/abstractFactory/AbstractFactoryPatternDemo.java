package designPattern.creational.abstractFactory;

/**
 * The Abstract Factory Pattern is a creational pattern that provides an
 * interface to create families of related objects without specifying their concrete classes.
 */
//Abstract Products
interface Button {
    void paint();
}

interface Checkbox {
    void paint();
}

//Concrete Products
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Windows Checkbox");
    }
}

// Mac UI
class MacButton implements Button {
    public void paint() {
        System.out.println("Mac Button");
    }
}

class MacCheckbox implements Checkbox {
    public void paint() {
        System.out.println("Mac Checkbox");
    }
}

//Abstract Factory
interface GUIFactory {
    Button createButton();

    Checkbox createCheckbox();
}

//Concrete Factories
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactoryPatternDemo {

    static void main() {

        GUIFactory factory;

        String os = "windows"; // runtime decision

        if (os.equalsIgnoreCase("mac")) {
            factory = new MacFactory();
        } else {
            factory = new WindowsFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.paint();
        checkbox.paint();
    }
}
