package javacore.function;

import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consumer =(p)-> System.out.println(p);
        consumer.accept("say hello");
    }
}
