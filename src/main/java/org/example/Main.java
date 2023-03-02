package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.operation.Addition;
import org.example.operation.Division;
import org.example.operation.Multiplication;
import org.example.operation.Subtraction;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Напишіть ваш вираз");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        String numberOne = "", numberTwo = "";
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                numberOne = numberTwo;
                numberTwo = "";
                a = i;
                i++;
            }
            numberTwo += str.charAt(i);
        }

        int x = Integer.parseInt(numberOne);
        int y = Integer.parseInt(numberTwo);

        calculation(x, y, str.charAt(a));
    }

    public static int calculation(int x, int y, char symbol) {
        Injector injector = Guice.createInjector(new MainModule());

        if (symbol == '+') {
            Addition addition = injector.getInstance(Addition.class);
            System.out.println(addition.add(x, y));
            return addition.add(x, y);

        } else if (symbol == '-') {

            Subtraction subtraction = injector.getInstance(Subtraction.class);
            System.out.println(subtraction.sub(x, y));
            return subtraction.sub(x, y);

        } else if (symbol == '*') {
            Multiplication multiplication = injector.getInstance(Multiplication.class);
            System.out.println(multiplication.mul(x, y));
            return multiplication.mul(x, y);

        } else if (symbol == '/') {
            Division division = injector.getInstance(Division.class);
            System.out.println(division.div(x, y));
            return division.div(x, y);

        } else {
            throw new IllegalStateException("Unknown character");
        }
    }
}