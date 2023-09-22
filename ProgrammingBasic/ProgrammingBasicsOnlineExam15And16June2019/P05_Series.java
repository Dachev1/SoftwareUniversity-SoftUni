package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P05_Series {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int serials = Integer.parseInt(scanner.nextLine());
        double totalSum = 0;
        for (int i = 1; i <= serials ; i++) {
            String name = scanner.nextLine();
            Double price = Double.parseDouble(scanner.nextLine());

            if (name.equals("Thrones")) {
                totalSum += price * 0.50;
            } else  if (name.equals("Lucifer")) {
                totalSum += price * 0.60;
            } else  if (name.equals("Protector")) {
                totalSum += price * 0.70;
            } else  if (name.equals("TotalDrama")) {
                totalSum += price * 0.80;
            } else  if (name.equals("Area")) {
                totalSum += price * 0.90;
            } else {
                totalSum += price;
            }
        }

        double diff = Math.abs(budget - totalSum);
        if (budget >= totalSum) {
            System.out.printf("You bought all the series and left with %.2f lv.", diff);
        } else {
            System.out.printf("You need %.2f lv. more to buy the series!", diff);
        }

    }
}
