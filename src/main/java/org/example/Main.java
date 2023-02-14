package org.example;

import org.example.operation.Addition;
import org.example.operation.Division;
import org.example.operation.Multiplication;
import org.example.operation.Subtraction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class.getPackageName());

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

        if (str.charAt(a) == '+') {
            Addition addition = applicationContext.getBean(Addition.class);
            System.out.println(addition.add(x, y));

        } else if (str.charAt(a) == '-') {
            Subtraction subtraction = applicationContext.getBean(Subtraction.class);
            System.out.println(subtraction.sub(x, y));

        } else if (str.charAt(a) == '*') {
            Multiplication multiplication = applicationContext.getBean(Multiplication.class);
            System.out.println(multiplication.mul(x, y));

        } else if (str.charAt(a) == '/') {
            Division division = applicationContext.getBean(Division.class);
            System.out.println(division.div(x, y));

        }
    }
}