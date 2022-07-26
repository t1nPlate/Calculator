package com.calculator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws IOException {
        File fileInput = new File("input.txt");
        File fileOutput = new File("output.txt");
        String result;
        FileReader fl = new FileReader(fileInput);
        FileWriter fw = new FileWriter(fileOutput, false);
        Scanner sc = new Scanner(fl);

        while(sc.hasNext()) {
            result = calculate(sc.nextLine(), fw);
            fw.write(result + "\n");
            fw.flush();
            System.out.println(result);
        }
    }

    static double division(double a, double b) throws Exception {
        if(b == 0) throw new Exception("Error! Division by zero");
        return a/b;
    }

    static String calculate(String str, FileWriter fw) throws IOException {
        String[] operation = str.split(" ");
        String result;
        double a, b;
        try {
            a = Double.parseDouble(operation[0]);
            b = Double.parseDouble(operation[2]);
        } catch (IllegalArgumentException ex) {
            result = "Error! Not number";
            fw.write(str + " = ");
            return result;
        } catch (NoSuchElementException ex) {
            result = "Empty line";
            fw.write(str + " = ");
            return result;
        }
        switch (operation[1]) {
            case "+" :
                result = String.valueOf(Math.round(Double.sum(a, b) * 100) / 100.0);
                fw.write(str + " = ");
                break;
            case "-" :
                result = String.valueOf(Math.round((a - b) * 100) / 100.0);
                fw.write(str + " = ");
                break;
            case "*" :
                result = String.valueOf(Math.round((a * b) * 100) / 100.0);
                fw.write(str + " = ");
                break;
            case "/" :
                try {
                    result = String.valueOf(division(a, b));
                    fw.write(str + " = ");
                    break;
                } catch (Exception ex) {
                    result = ex.getMessage();
                    fw.write(str + " = ");
                    break;
                }
            default :
                result = "Operation Error!";
                fw.write(str + " = ");
                break;
        }
        return result;
    }
}
