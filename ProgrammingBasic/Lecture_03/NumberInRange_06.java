package Lecture_03;

import java.util.Scanner;

public class NumberInRange_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        boolean isBool = (number >= -100) && (number <= 100) && (number != 0);

        if (isBool) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}