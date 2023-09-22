package Lecture_03;

import java.util.Scanner;

public class TradeCommissions_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        double sells = Double.parseDouble(scanner.nextLine());

        double com = -1;
        if ("Sofia".equals(town)) {
            if (sells <= 500) {
                com = 0.05;
            } else if (sells <= 1000) {
                com = 0.07;
            } else if (sells <= 10000) {
                com = 0.08;
            } else if (sells > 10000) {
                com = 0.12;
            }
        } else if ("Varna".equals(town)) {
            if (sells <= 500) {
                com = 0.045;
            } else if (sells <= 1000) {
                com = 0.075;
            } else if (sells <= 10000) {
                com = 0.1;
            } else if (sells > 10000) {
                com = 0.13;
            }
        } else if ("Plovdiv".equals(town)) {
            if (sells <= 500) {
                com = 0.055;
            } else if (sells <= 1000) {
                com = 0.08;
            } else if (sells <= 10000) {
                com = 0.12;
            } else if (sells > 10000) {
                com = 0.145;
            }
        }

        if (com > 0 && sells >
                0) {
            System.out.printf("%.2f", sells * com);
        } else {
            System.out.println("error");
        }
    }
}

