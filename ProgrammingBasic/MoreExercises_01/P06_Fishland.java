package MoreExercises_01;

import java.util.Scanner;

public class P06_Fishland {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double priceForKgMackerel = Double.parseDouble(scanner.nextLine());
        double priceForKgSprattus = Double.parseDouble(scanner.nextLine());
        double priceForKgBonito = Double.parseDouble(scanner.nextLine());
        double priceForKgTrachurus = Double.parseDouble(scanner.nextLine());
        double priceForKgBivalvia  = Double.parseDouble(scanner.nextLine());

        double priceBonito = priceForKgMackerel + priceForKgMackerel * 0.60;
        double sumBonito = priceForKgBonito * priceBonito;
        double priceTrachurus = priceForKgSprattus + priceForKgSprattus * 0.80;
        double sumTrachurus = priceForKgTrachurus * priceTrachurus;
        double sumBivalvia = priceForKgBivalvia * 7.50;

        double totalPrice = sumBonito + sumTrachurus + sumBivalvia;

        System.out.printf("%.2f",totalPrice);


    }
}

