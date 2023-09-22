package EXAM;

import java.util.Scanner;

public class P06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currentNumber = Integer.parseInt(scanner.nextLine());

        int digitOne = currentNumber / 100;
        int digitTwo = currentNumber / 10 % 10;
        int digitThree= currentNumber % 10;

        for (int i = 1; i <= digitThree; i++) {
            for (int j = 1; j <= digitTwo ; j++) {
                for (int k = 1; k <= digitOne ; k++) {
                    System.out.printf("%d * %d * %d = %d;%n", i,j,k, (i * j * k));
                }
            }
        }
    }
}