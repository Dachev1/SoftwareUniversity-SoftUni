package Lecture_02.LectureEXC_02;

import java.util.Scanner;

public class Shopping_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double videoCardCount = Integer.parseInt(scanner.nextLine());
        double processorCount = Integer.parseInt(scanner.nextLine());
        double ramCount = Integer.parseInt(scanner.nextLine());

        double videoCardPrice = videoCardCount * 250;
        double processorPrice = processorCount * (videoCardPrice * 0.35);
        double ramPrice = ramCount * (videoCardPrice * 0.1);

        double total = videoCardPrice + processorPrice + ramPrice;
        if (videoCardCount > processorCount) {
            total = total - (total * 0.15);
        }

        double diff = Math.abs(budget - total);

        if (budget >= total) {
            System.out.printf("You have %.2f leva left!", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva more!", diff);
        }
    }
}
