package designPattern.structural.decorator;

/**
 * Decorator Pattern is a Structural Design Pattern used to
 * add new behavior to an object dynamically without changing its class.
 */
interface Coffee {
    String getDescription();

    int cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple Coffee";
    }

    public int cost() {
        return 5;
    }
}

//Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription();
    }

    public int cost() {
        return coffee.cost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + Milk";
    }

    public int cost() {
        return coffee.cost() + 2;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public String getDescription() {
        return coffee.getDescription() + " + Sugar";
    }

    public int cost() {
        return coffee.cost() + 1;
    }
}

public class Decorator {
    static void main() {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription());
        System.out.println(coffee.cost());
    }
}
