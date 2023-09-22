package Exercise_September_15;

import java.util.Scanner;

public class P06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number;

        int totalFactSum = 0;
        while (number > 0) {
            int lastDigit = number % 10;

            int fact = 1;
            for (int i = 1; i <= lastDigit ; i++) {
                fact = fact * i;
            }

            totalFactSum += fact;
            number /= 10;
        }

        if (totalFactSum == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}



