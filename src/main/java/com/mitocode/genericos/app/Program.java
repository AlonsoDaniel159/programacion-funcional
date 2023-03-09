package com.mitocode.genericos.app;

import com.mitocode.genericos.model.Car;
import com.mitocode.genericos.model.Mazda;
import com.mitocode.genericos.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Program {

    //T = type | tipo
    //K = key
    //V = value
    //ID
    // wildcart | unknown

    private void m1(List<? extends Car> list) {

    }

    private void m2(List<? super Car> list) {

    }

    public static void main(String[] args) {
        Program app = new Program();

        //List<Mazda> lst = new ArrayList<>();
        List<Mazda> lst2 = new ArrayList<>();
        //List<Vehicle> lst = new ArrayList<>();

        app.m1(lst2);
        //app.m2(lst);
    }
}
