package designPattern.solid.interfaceSegregation;

/**
 * Clients should not be forced to depend on interfaces they do not use. It is better to have many small,
 * focused interfaces than one large, "fat" interface.
 */


/*public interface Vehicle {
    void drive();
    void stop();
    void refuel();
    void openDoors();
}

public class Bicycle implements Vehicle {
    // implements drive, stop, refuel (maybe)
    @Override
    public void openDoors() {
        // Bicycles don't have doors, forcing a dummy implementation or exception
    }
}
The Bicycle class is forced to implement a method (openDoors) that is irrelevant to it.
*/
interface DrivingVehicle {
    void drive();

    void stop();
}

interface Refuelable {
    void refuel();
}

interface DoorOperable {
    void openDoors();
}

class Bicycle implements DrivingVehicle, Refuelable {
    @Override
    public void drive() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void refuel() {

    }
    // implements only relevant methods
}

public class InterfaceSegregation {
}
