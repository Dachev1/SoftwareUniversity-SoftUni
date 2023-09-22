package Lecture_06;

import java.util.Scanner;

public class P05_Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();


        while (!destination.equals("End")) {
            double neededMoney = Double.parseDouble(scanner.nextLine());

            double budget = 0;
            while (neededMoney > budget) {
                double savedMoney = Double.parseDouble(scanner.nextLine());
                budget += savedMoney;
            }

            System.out.println("Going to " + destination + "!");
            destination = scanner.nextLine();
        }
    }
}
