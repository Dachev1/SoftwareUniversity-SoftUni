package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P01_Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeProjection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        double price = 0;
        switch (typeProjection) {
            case "Premiere":
                price = 12;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5;
                break;
        }

        double totalPrice = rows * cols * price;
        System.out.printf("%.2f leva", totalPrice);
    }
}
