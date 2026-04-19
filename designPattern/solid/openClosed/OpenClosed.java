package designPattern.solid.openClosed;

//Definition: Software entities (classes, modules, functions, etc.) should be open for extension but closed for
// modification. This means you can add new functionality without changing existing code.

/*public class AreaCalculator {
    public double calculateArea(Shape shape) {
        if (shape instanceof Square) {
            // calculate square area
        } else if (shape instanceof Circle) {
            // calculate circle area
        }
        return 0.0;
    }
}
Adding a new shape (e.g., Triangle) would require modifying the calculateArea method, violating OCP.
*/

interface Shape {
    double area();
}

class Square implements Shape {
    @Override
    public double area() {
        // calculate square area
        return 0.0;
    }
}

class Circle implements Shape {
    @Override
    public double area() {
        // calculate circle area
        return 1.0;
    }
}

public class OpenClosed {
    static void main(String[] args) {
        Square square = new Square();
        Circle circle = new Circle();
        System.out.println(square.area());
        System.out.println(circle.area());
    }
}
