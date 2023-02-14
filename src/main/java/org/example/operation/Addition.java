package org.example.operation;

import org.springframework.stereotype.Component;

@Component
public class Addition {
    public int add(int numberOne, int numberTwo) {
        return numberOne + numberTwo;
    }
}
