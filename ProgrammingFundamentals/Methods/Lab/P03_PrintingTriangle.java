package ProgrammingFundamentals.Methods.Lab;

import java.util.Scanner;

public class P03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printTriangle(size);
    }

    public static void printTriangle(int size) {
        for (int i = 1; i < size; i++) {
            printRow(i);
            System.out.println();
        }

        for (int i = size; i > 0; i--) {
            printRow(i);
            System.out.println();
        }
    }

    public static void printRow(int size) {
        for (int i = 1; i <= size; i++) {
            System.out.printf("%d ", i);
        }
    }
}
