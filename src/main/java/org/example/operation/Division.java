package org.example.operation;

import org.springframework.stereotype.Component;

@Component
public class Division {
    public int div(int numberOne, int numberTwo) {
        return numberOne / numberTwo;
    }
}
