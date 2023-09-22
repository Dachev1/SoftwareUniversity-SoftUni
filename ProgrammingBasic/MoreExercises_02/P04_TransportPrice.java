package MoreExercises_02;

import java.util.Scanner;

public class P04_TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int km = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();

        double taxiRatio = 0.70;
        double price = 0;
        if (km < 20) {
           if ("day".equals(dayOrNight)) {
               price = taxiRatio + (km * 0.79);
           } else {
               price = taxiRatio + km * 0.90;
           }
        } else if (km < 100) {
            price = km * 0.09;
        } else {
            price = km * 0.06;
        }

        System.out.printf("%.2f",price);
    }
}
