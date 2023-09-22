package EXAM;

import java.util.Scanner;

public class P02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double partyPrice = Double.parseDouble(scanner.nextLine());
        int loveMessagesCount = Integer.parseInt(scanner.nextLine());
        int rosesCount = Integer.parseInt(scanner.nextLine());
        int keyChainsCount = Integer.parseInt(scanner.nextLine());
        int cartoonsCount =  Integer.parseInt(scanner.nextLine());
        int surpriseCount =  Integer.parseInt(scanner.nextLine());

        double totalPrice = (loveMessagesCount * 0.60) + (rosesCount * 7.20) + (keyChainsCount * 3.60) + (cartoonsCount * 18.20) + (surpriseCount * 22);

        if (loveMessagesCount + rosesCount + keyChainsCount + cartoonsCount + surpriseCount  >= 25) {
            totalPrice = totalPrice - (totalPrice * 0.35);
        }

        double hostingCost = totalPrice * 0.10;
        double profit = totalPrice - hostingCost;

        double diff = Math.abs(profit - partyPrice);

        if (profit >= partyPrice) {
            System.out.printf("Yes! %.2f lv left.", diff);
        } else {
            System.out.printf("Not enough money! %.2f lv needed.", diff);
        }
    }
}