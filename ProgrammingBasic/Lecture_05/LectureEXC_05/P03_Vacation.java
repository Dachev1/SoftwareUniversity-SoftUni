package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double neededMoney = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());

        int spendDaysCount = 0;
        int daysCount = 0;

        while (availableMoney < neededMoney) {
            if (spendDaysCount == 5) {
                break;
            }

            String input = scanner.nextLine();
            double currentMoney = Double.parseDouble(scanner.nextLine());

            daysCount++;

            if (input.equals("spend")) {
                availableMoney -= currentMoney;
                spendDaysCount++;
            } else if (input.equals("save")) {
                availableMoney += currentMoney;
                spendDaysCount = 0;
            }

            if (availableMoney < 0) {
                availableMoney = 0;
            }
        }

        if (spendDaysCount == 5) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", daysCount);
        } else {
            System.out.printf("You saved the money for %d days.", daysCount);
        }
    }
}
