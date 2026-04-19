package java8Fetaure;

import java.util.Optional;
import java.util.stream.Stream;

@FunctionalInterface
interface MyInterface {
    abstract void method();

    static String producer() {
        return "N&F Vehicles";
    }

    default String getOverview() {
        return "ATV made by " + producer();
    }
}

public class StaticAndDefaultMethod {
    MyInterface myInterface = () -> {
        System.out.println("Hello from method");
    };

    static void main() {
        Stream<String> stream =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream.findAny();
        System.out.println(MyInterface.producer());
        StaticAndDefaultMethod staticAndDefaultMethod = new StaticAndDefaultMethod();
        staticAndDefaultMethod.myInterface.method();
        System.out.println(staticAndDefaultMethod.myInterface.getOverview());
    }

}
