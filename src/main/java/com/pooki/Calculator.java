package com.pooki;

/**
 * @author Bingqi Xia
 * @version 1.0
 * @date 16/07/2023 21:23
 */
public class Calculator {
    public int add(int first, int second) {
        return first + second;
    }

    public double divide(double numerator, double denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Can't divide by zero");
        }
        return numerator / denominator;
    }
}
