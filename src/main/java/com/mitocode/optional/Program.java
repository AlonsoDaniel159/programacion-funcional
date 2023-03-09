package com.mitocode.optional;

import com.mitocode.function.Employee;

import java.time.LocalDate;
import java.util.Optional;

public class Program {

    private void m1Optional() {
        /*Optional<Employee> optional = Optional.of(
                new Employee(1, "mitocode", "Programmer",
                LocalDate.now(), 500.50, "TI"));*/
        Optional<Employee> optional = Optional.empty();

        Employee emp = optional.orElse(new Employee());
        System.out.println(emp);
    }

    public static void main(String[] args) {
        Program app = new Program();
        app.m1Optional();

    }
}
