package Lecture_04;

import java.util.Scanner;

public class P09_LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i <= n; i++) {
            int numbers1 = Integer.parseInt(scanner.nextLine());
            sum1 += numbers1;
        }

        for (int j = 1; j <= n; j++) {
            int numbers2 = Integer.parseInt(scanner.nextLine());
            sum2 += numbers2;
        }

        if (sum1 == sum2) {
            System.out.printf("Yes, sum = %d", sum1);
        } else {
            int diff = Math.abs(sum1 - sum2);
            System.out.printf("No, diff = %d", diff);
        }
    }
}
