package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char startSymbol = scanner.nextLine().charAt(0);
        char endSymbol = scanner.nextLine().charAt(0);

        printSymbols(startSymbol, endSymbol);
    }

    public static void printSymbols(char startSymbol, char endSymbol) {
        if (startSymbol < endSymbol) {
        for (int i = startSymbol + 1; i < endSymbol; i++) {
            System.out.print((char) i + " ");
            }
        } else {
            for (int i = endSymbol + 1; i < startSymbol; i++) {
                System.out.print((char) i + " ");
            }
        }
    }
}
