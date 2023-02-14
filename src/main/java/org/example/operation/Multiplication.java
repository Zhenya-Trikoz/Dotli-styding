package org.example.operation;

import org.springframework.stereotype.Component;

@Component
public class Multiplication {
    public int mul(int numberOne, int numberTwo) {
        return numberOne * numberTwo;
    }
}
