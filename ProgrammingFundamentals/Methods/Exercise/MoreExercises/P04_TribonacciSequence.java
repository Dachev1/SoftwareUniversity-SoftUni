package ProgrammingFundamentals.Methods.Exercise.MoreExercises;

import java.util.Scanner;

public class P04_TribonacciSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        printTribonacciSeq(n);
    }

    private static void printTribonacciSeq(int n) {

        if (n == 1) {
            System.out.println(1);
        }  else if (n == 2) {
            System.out.println(1 + " " + 1);
        } else {

            int a = 1, b = 1, c = 2;
            int d = a + b + c;

            System.out.print(a + " " + b + " " + c);

            for (int i = 4; i <= n; i++) {
                System.out.print(" " + d);
                a = b;
                b = c;
                c = d;
                d = a + b + c;
            }

            System.out.println();
        }
    }
}




