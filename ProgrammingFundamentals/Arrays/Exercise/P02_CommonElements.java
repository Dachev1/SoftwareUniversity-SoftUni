package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Scanner;

public class P02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] text1 = scanner.nextLine().split(" ");
        String[] text2 = scanner.nextLine().split(" ");

        for (String el2: text2) {
            for (String el1: text1) {
                if (el2.equals(el1)) {
                    System.out.print(el2 + " ");
                }
            }
        }
    }
}
