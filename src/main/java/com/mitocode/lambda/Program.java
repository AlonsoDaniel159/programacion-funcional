package com.mitocode.lambda;

import java.util.function.Supplier;

public class Program {
    public static void main(String[] args) {

        /*Operation op = new Sum();

        int rpta = op.operate(10, 20);
        System.out.println(rpta);*/

        Operation<Integer> op = n -> n >= 18;
        boolean rpta = op.operate(25);
        System.out.println(rpta);

    }
}
