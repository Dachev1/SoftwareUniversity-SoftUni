package MoreExercises_02;

import java.util.Scanner;

public class P06_FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int magnolia = Integer.parseInt(scanner.nextLine());
        int hyacinth  = Integer.parseInt(scanner.nextLine());
        int rose = Integer.parseInt(scanner.nextLine());
        int cactus = Integer.parseInt(scanner.nextLine());
        double giftPrice = Double.parseDouble(scanner.nextLine());

        double total = 3.25 * magnolia + 4 * hyacinth + 3.50 * rose + 8 * cactus;
        double totalWithTax = total * 0.95;
        double diff = Math.abs(totalWithTax - giftPrice);

        if (totalWithTax >= giftPrice) {
            System.out.printf("She is left with %.0f leva." , Math.floor(diff));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(diff));
        }
    }
}
