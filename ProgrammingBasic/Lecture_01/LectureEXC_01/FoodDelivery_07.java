package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class FoodDelivery_07 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int veganMenu = Integer.parseInt(scanner.nextLine());

        double chickenMenuPrice = chickenMenu * 10.35;
        double fishMenuPrice = fishMenu * 12.40;
        double veganMenuPrice = veganMenu * 8.15;
        double delivery = 2.50;

        double totalMenuPrice = chickenMenuPrice + fishMenuPrice + veganMenuPrice;
        double dessertPrice = totalMenuPrice * 0.2;

        double finalPrice = totalMenuPrice + dessertPrice + delivery;

        System.out.println(finalPrice);

    }
}
