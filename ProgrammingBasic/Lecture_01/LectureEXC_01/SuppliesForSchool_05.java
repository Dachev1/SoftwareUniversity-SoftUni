package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class SuppliesForSchool_05 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int packsPens = Integer.parseInt(scanner.nextLine());
        int packsHighlighters = Integer.parseInt(scanner.nextLine());
        int packsCleaningAgentsLiters = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());

        double priceForPens = packsPens * 5.80;
        double priceForHighlighters = packsHighlighters * 7.20;
        double priceForCleaningAgents = packsCleaningAgentsLiters * 1.20;

        double totalSumForSupplies = priceForPens + priceForHighlighters + priceForCleaningAgents;
        double finalPrice = totalSumForSupplies - (totalSumForSupplies * (discount / 100.0));

        System.out.println(finalPrice);
    }
}
