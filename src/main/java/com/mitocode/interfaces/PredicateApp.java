package com.mitocode.interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateApp {

    private void method1() {
        Predicate<Integer> checkAgeNumber = x -> x >= 18;

        Predicate<Person> checkAge = p -> p.getAge() >= 18;

        boolean rpta = checkAge.test(new Person(1, "Alonso", 21));

        System.out.println(rpta);
    }

    private void method2() {
        Predicate<Integer> greaterThan = x -> x > 10;
        Predicate<Integer> lowerThan = x -> x < 20;

        boolean rpta = greaterThan.and(lowerThan).test(15);
        boolean rpta2 = greaterThan.or(lowerThan).test(15);

        System.out.println(rpta);
    }

    private void method3(int num, Predicate<Integer> fx) {
        boolean rpta = fx.test(num);
        System.out.println(rpta);
    }

    public static void main(String[] args) {
        PredicateApp app = new PredicateApp();
        app.method3(1, x -> x > 5);

    }
}
