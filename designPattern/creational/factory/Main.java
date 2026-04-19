package designPattern.creational.factory;

/**
 * The Factory Pattern is a creational design pattern used to create objects without exposing the
 * instantiation logic to the client.
 * Instead of using new, you delegate object creation to a factory class
 */
//Product Interface
interface Shape {
    void draw();
}

//Concrete Classes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

class ShapeFactory {

    public static Shape getShape(String type) {
        if (type == null) return null;

        return switch (type.toLowerCase()) {
            case "circle" -> new Circle();
            case "rectangle" -> new Rectangle();
            default -> throw new IllegalArgumentException("Invalid shape type");
        };
    }
}

public class Main {
    static void main() {
        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("rectangle");
        shape2.draw();
    }
}
