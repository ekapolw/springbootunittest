package com.technicallab.springbootunittest.unittest;

import org.springframework.beans.factory.annotation.Autowired;

public class Square {

    @Autowired
    private Calculator calculator;

    public int area(int i) {
        return calculator.multiple(i, i);
    }

    public int length(int i) {
        return calculator.add(i, i) * 2;
    }
}
