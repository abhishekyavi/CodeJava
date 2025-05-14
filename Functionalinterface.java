package CodeJava;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Functionalinterface {
    public static void main(String[] args) {

        System.out.println("Functional Interface Example");

        Function<String, String> touper = s -> s.toUpperCase();
        System.out.println(touper.apply("hello world"));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        isEven.test(10);

        Consumer<Integer> c = n -> System.out.println(n);
        c.accept(10);

        Supplier<Double> s = () -> Math.random();
        System.out.println(s.get());

        //--------------------------------------------

        
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20));

        UnaryOperator<String> u = e -> e + " is a string";
        System.out.println(u.apply("hello world"));

        BiFunction<String, String, String> concat = (a, b) -> a + b;
        System.out.println(concat.apply("hello", " world"));

    }

}
