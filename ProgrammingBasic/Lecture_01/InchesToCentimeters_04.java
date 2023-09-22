package Lecture_01;

import java.util.Scanner;

public class InchesToCentimeters_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double inch = Double.parseDouble(scanner.nextLine());
        double cm = (inch * 2.54);

        System.out.println(cm);
    }
}
