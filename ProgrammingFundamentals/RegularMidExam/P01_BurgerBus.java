package ProgrammingFundamentals.RegularMidExam;

import java.util.Scanner;

public class P01_BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int visitedCities = Integer.parseInt(scanner.nextLine());

        double totalProfit = 0;
        for (int i = 1; i <= visitedCities; i++) {
            String cityName = scanner.nextLine();
            double earnedMoney = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());


            if (i % 3 == 0 && i % 5 != 0) {
                expenses += expenses / 2;
            }

            if (i % 5 == 0 ) {
                earnedMoney *= 0.90;
            }


            earnedMoney -= expenses;

            System.out.printf("In %s Burger Bus earned %.2f leva.\n", cityName, earnedMoney);
            totalProfit += earnedMoney;
        }

        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}
