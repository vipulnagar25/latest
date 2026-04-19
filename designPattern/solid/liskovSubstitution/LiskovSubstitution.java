package designPattern.solid.liskovSubstitution;

//Definition: Derived (sub) classes must be able to replace their base (parent) classes
// without affecting the correctness of the program.
/*
public abstract class Bird {
    abstract void fly();
}

public class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}

An Ostrich object cannot be used where a generic Bird (expected to fly) is expected, causing unexpected runtime behavior.

*/
abstract class FlyingBird {
    abstract void fly();
}

abstract class NonFlyingBird {
    // methods relevant to non-flying birds
}

class Eagle extends FlyingBird {
    @Override
    public void fly() {
        // implementation for flying
    }
}

class Ostrich extends NonFlyingBird {
    // implementation for non-flying birds
}

public class LiskovSubstitution {
}
