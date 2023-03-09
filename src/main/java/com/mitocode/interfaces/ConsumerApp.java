package com.mitocode.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerApp {

    public void method1() {
        Consumer<String> print = System.out::println;
        //print.accept("Que onda pa");

        List<String> list = List.of("Hola", "Mundo");
        list.forEach(print::accept);
    }

    public void method2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> consumer = x -> {
            x+=2;
            System.out.println(x);
        };

        listAll(list, consumer);

    }

    //High Order Function
    private <T> void listAll(List<T> list, Consumer<T> consumer) {
        for (T t: list) {
            consumer.accept(t);
        }
    }

    public static void main(String[] args) {

        ConsumerApp app = new ConsumerApp();
        app.method2();
    }
}
