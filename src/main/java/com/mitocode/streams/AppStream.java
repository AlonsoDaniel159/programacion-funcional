package com.mitocode.streams;

import com.mitocode.function.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppStream {

    private void m1getDevelopers(List<Employee> list) {

        List<Employee> newList = list.stream()
                .filter(e -> e.getJob().toLowerCase().contains("developer"))
                .collect(toList());

        newList.forEach(System.out::println);
    }

    private void m2getInverse(List<Employee> list) {

        Comparator<Employee> inverse = (x1, x2) -> x2.getIdEmployee() - x1.getIdEmployee();

        list.stream()
                .sorted(inverse)
                .forEach(System.out::println);
    }

    private void m3getAdults(List<Employee> list) {

        Predicate<Employee> isAdult = e -> {
            return Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;
        };

        list.stream()
                .filter(isAdult)
                .forEach(System.out::println);
    }

    //El emploeado más viejo
    private void m4getOldestAdult(List<Employee> list) {
        Comparator<Employee> inverse = (x1, x2) -> x1.getBirthDate().getYear() - x2.getBirthDate().getYear();

        list.stream()
                .sorted(Comparator.comparing(Employee::getBirthDate))
                .limit(1)
                .forEach(System.out::println);

        //Otra manera
        Employee employee = list.stream()
                .max(Comparator.comparing(Employee::getBirthDate).reversed())
                .get();

        System.out.println(employee);

    }

    private void m5getMaxMinSalary(List<Employee> list) {

        double max = list.stream()
                .map(Employee::getSalary)
                .max(Double::compareTo)
                .orElse(0.0);

        double min = list.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);

        System.out.println("Max: " + max + ", Min: " + min);

        Employee emp = list.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(new Employee());

        System.out.println(emp);
    }

    //Promedio
    public void m6getAverage(List<Employee> list) {
        double average = list.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        System.out.println(average);
    }

    //Obtener resumen
    public void m7getSummary(List<Employee> list) {
        DoubleSummaryStatistics stats = list.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        System.out.println(stats);
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());

    }

    //Compara para evitar repetidos
    public void m8getDistinct(List<Employee> list) {
        list.stream()
                .distinct()
                .forEach(System.out::println);
    }

    public void m9getCount(List<Employee> list) {
        long count = list.stream()
                .filter(e -> e.getSalary() >= 5000)
                .count();

        System.out.println(count);
    }

    public void m10skip(List<Employee> list) {
        list.stream()
                .skip(3)
                .forEach(System.out::println);
    }

    //Verificar si hay algún menor de edad
    public void m11getAnyYounger(List<Employee> list) {
        boolean exist = list.stream()
                .anyMatch(e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() < 18);

        System.out.println(exist);
    }

    public void m12Map(List<Employee> list) {
        list.stream()
                .map(e -> {
                    e.setSalary(e.getSalary() * 1.10);
                    return e.getSalary();
                })
                .forEach(System.out::println);
    }

    public void m13FlatMap(List<Employee> list) {
        list.stream()
                .flatMap(e -> {
                    e.setSalary(e.getSalary() * 1.10);
                    return Stream.of(e.getSalary(), "a", "b");
                })
                .forEach(System.out::println);
    }

    public void m14Peek(List<Employee> list) {
        List<Employee> lst = list.stream()
                .filter(e -> e.getSalary() > 1000)
                .peek(System.out::println)
                .collect(toList());

        //System.out.println(lst);
    }

    public void m15GroupBy(List<Employee> list) {
        Map<String, List<Employee>> byDepartment = list.stream()
                .collect(groupingBy(Employee::getDepartment));

        byDepartment.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n");
        byDepartment.get("TI").forEach(System.out::println);
        byDepartment.get("Comercial").forEach(System.out::println);
    }

    public void m16toMapToSet(List<Employee> list) {
        Map<Integer, String> map = list.stream()
                .collect(toMap(Employee::getIdEmployee, Employee::getName));

        //Set<Employee> set = new HashSet<>();
        //System.out.println(map.keySet());
        //System.out.println(map.values());
        //map.entrySet().stream().forEach(System.out::println);
    }

    public void m18Order(List<Employee> list) {
        list.stream()
                .sorted(Comparator.comparingInt(Employee::getIdEmployee).reversed())
                .forEach(System.out::println);

        Stream.of(1, 2, 3, 4, 5)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        AppStream app = new AppStream();

        Employee e1 = new Employee(1, "Mito1", "Developer", LocalDate.of(1991, 1, 1), 1000.00, "TI");
        Employee e2 = new Employee(2, "Mito2", "QA", LocalDate.of(1993, 2, 1), 2000.00, "TI");
        Employee e3 = new Employee(3, "Mito3", "Arhictect", LocalDate.of(1995, 3, 1), 3000.00, "TI");
        Employee e4 = new Employee(4, "Mito4", "Cloud Engenieer", LocalDate.of(1987, 4, 1), 4000.00, "TI");
        Employee e5 = new Employee(5, "Mito5", "DevOps Engenieer", LocalDate.of(1956, 1, 1), 5000.00, "TI");
        Employee e6 = new Employee(6, "Mito6", "Scrum Master", LocalDate.of(2004, 11, 1), 4500.00, "TI");
        Employee e7 = new Employee(7, "Mito7", "Leader Project", LocalDate.of(1998, 12, 1), 10000.00, "TI");
        Employee e8 = new Employee(8, "Mito8", "Senior Developer", LocalDate.of(1996, 7, 1), 7000.00, "TI");
        Employee e9 = new Employee(9, "Mito9", "Junior Developer", LocalDate.of(2002, 8, 1), 500.00, "TI");
        Employee e10 = new Employee(10, "Mito10", "Mobile Developer", LocalDate.of(1975, 9, 1), 3000.00, "TI");
        Employee e11 = new Employee(11, "Mito11", "Salesman", LocalDate.of(1994, 9, 1), 2000.00, "Comercial");

        List<Employee> list = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
        app.m18Order(list);
    }
}
