package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P05_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = Double.parseDouble(scanner.nextLine());

        double totalSumCoins  = Math.floor(sum * 100);
        int coinsCount = 0;

        while (totalSumCoins  > 0) {

            if (totalSumCoins >= 200) {
                totalSumCoins  -= 200;
                coinsCount++;
            } else if (totalSumCoins  >= 100) {
                totalSumCoins  -= 100;
                coinsCount++;
            } else if (totalSumCoins  >= 50) {
                totalSumCoins  -= 50;
                coinsCount++;
            } else if (totalSumCoins  >= 20) {
                totalSumCoins  -= 20;
                coinsCount++;
            } else if (totalSumCoins  >= 10) {
                totalSumCoins  -= 10;
                coinsCount++;
            } else if (totalSumCoins  >= 5) {
                totalSumCoins  -= 5;
                coinsCount++;
            } else if (totalSumCoins  >= 2) {
                totalSumCoins  -= 2;
                coinsCount++;
            } else if (totalSumCoins  >= 1) {
                totalSumCoins  -= 1;
                coinsCount++;
            }
        }

        System.out.printf("%d", coinsCount);
    }
}
