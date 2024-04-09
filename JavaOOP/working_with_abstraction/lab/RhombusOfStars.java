package working_with_abstraction.lab;

import java.util.Scanner;

public class RhombusOfStars {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        for (int starCount = 1; starCount <= size; starCount++) {
            printRow(size, starCount);
        }

        for (int starCount = size - 1; starCount >= 1; starCount--) {
            printRow(size, starCount);
        }
    }

    private static void printRow(int size, int starCount) {
        for (int i = 0; i < size - starCount; i++) {
            System.out.print(" ");
        }

        for (int i = 1; i < starCount; i++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }
}
