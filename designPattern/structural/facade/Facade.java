package designPattern.structural.facade;

/**
 * Facade Pattern provides a simplified interface to a complex subsystem.
 * <p>
 * Instead of the client calling multiple classes, the client calls one Facade class,
 * and the facade internally calls all subsystem classes.
 */
class CPU {
    public void start() {
        System.out.println("CPU started");
    }
}

class Memory {
    public void load() {
        System.out.println("Memory loaded");
    }
}

class HardDrive {
    public void read() {
        System.out.println("Hard Drive read");
    }
}
class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.start();
        memory.load();
        hardDrive.read();
    }
}
public class Facade {
    static void main() {
        ComputerFacade computer = new ComputerFacade();
        computer.startComputer();
    }
}
