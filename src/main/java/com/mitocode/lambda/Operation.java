package com.mitocode.lambda;

@FunctionalInterface
public interface Operation<t> {

    boolean operate(t x);

    //int operate2(int x, int y);

}
