package ProgrammingFundamentals.MidExamsPractise.Exam6;

import java.util.Scanner;

public class P01_BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder  = Integer.parseInt(scanner.nextLine());
        double expectedPlunder  = Integer.parseInt(scanner.nextLine());

        double earnPlunder = 0;
        for (int day = 1; day <= days; day++) {
            earnPlunder += dailyPlunder;

            if (day % 3 == 0) {
                earnPlunder += (dailyPlunder * 1.0) / 2;
            }

            if (day % 5 == 0) {
                earnPlunder *= 0.70;
            }
        }

        if (earnPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.\n", earnPlunder);
        } else {
            double percent = (earnPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percent);
        }
    }
}
