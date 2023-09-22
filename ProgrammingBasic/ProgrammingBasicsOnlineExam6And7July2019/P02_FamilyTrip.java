package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P02_FamilyTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());;
        int nights = Integer.parseInt(scanner.nextLine());;
        double pricePerNight = Double.parseDouble(scanner.nextLine());
        int percentForAdditionalCosts = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (nights > 7) {
            pricePerNight *= 0.95;
            price += pricePerNight * nights;
        } else {
            price += pricePerNight * nights;
        }

        price += (percentForAdditionalCosts * 1.0 / 100) * budget;

        double diff = Math.abs(price - budget);
        if (budget >= price) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", diff);
        } else {
            System.out.printf("%.2f leva needed.", diff);
        }
    }
}
