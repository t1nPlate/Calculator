package com.calculator;

import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        final String fileName = "C:/Users/Dmitryi/IdeaProjects/Calculator/src/com/calculator/input.txt";
        FileReader fl = new FileReader(fileName);
        Scanner sc = new Scanner(fl);
        try {
            calculate(sc.nextLine());
        } catch (NoSuchElementException ex) {
            System.out.println("Empty line");
        }
    }

    static double division(double a, double b) throws Exception {
        if(b == 0) throw new Exception("Error! Division by zero");
        return a/b;
    }

    static void calculate(String str) {
        String[] operation = str.split(" ");
        double a, b;
        try {
            a = Double.parseDouble(operation[0]);
            b = Double.parseDouble(operation[2]);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error! Not number");
            return;
        }
        switch (operation[1]) {
            case "+" : System.out.println(Math.round(Double.sum(a, b) * 100) / 100.0); break;
            case "-" : System.out.println(Math.round((a - b) * 100) / 100.0); break;
            case "*" : System.out.println(Math.round((a * b) * 100) / 100.0); break;
            case "/" :
                try {
                    System.out.println(division(a, b));
                    break;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    break;
                }
            default : System.out.println("Operation Error!"); break;
        }
    }
}
