package com.mitocode.interfaces;

import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierApp {

    private void method1() {
        Supplier<LocalDateTime> fx = () -> {
          return LocalDateTime.now().minusDays(2);
        };
        System.out.println(fx.get());
    }

    public static void main(String[] args) {
        SupplierApp app = new SupplierApp();
        app.method1();
    }
}
