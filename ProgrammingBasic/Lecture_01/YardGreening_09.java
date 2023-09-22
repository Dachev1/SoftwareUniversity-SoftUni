package Lecture_01;

import java.util.Scanner;

public class YardGreening_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double meters = Double.parseDouble(scanner.nextLine());
        double sum = (meters * 7.61);
        double priceDiss = 0.18 * sum;
        double price = sum - priceDiss;

        System.out.printf("The final price is: %.2f lv." + "\n" + "The discount is: %.2f lv.", price, priceDiss);
    }
}
