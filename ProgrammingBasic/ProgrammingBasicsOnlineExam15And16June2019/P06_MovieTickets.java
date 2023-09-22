package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P06_MovieTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a1 = Integer.parseInt(scanner.nextLine());
        int a2 = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = a1; i < a2; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < n / 2; k++) {
                    if (i % 2 != 0 && (j + k + i) % 2 != 0) {
                        System.out.println(String.format("%c-%d%d%d", i, j, k, i));
                    }
                }
            }
        }
    }
}
