package org.example.operation;

import org.springframework.stereotype.Component;

@Component
public class Subtraction {
    public int sub(int numberOne, int numberTwo) {
        return numberOne - numberTwo;
    }
}
