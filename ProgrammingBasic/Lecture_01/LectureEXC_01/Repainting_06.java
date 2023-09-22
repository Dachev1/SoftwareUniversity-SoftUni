package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class Repainting_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int neededNylon = Integer.parseInt(scanner.nextLine());
        int neededPaint = Integer.parseInt(scanner.nextLine());
        int neededThinner = Integer.parseInt(scanner.nextLine());
        int neeededHours = Integer.parseInt(scanner.nextLine());

        double nylonPrice = (neededNylon + 2) * 1.50;
        double paintPrice = (neededPaint + neededPaint * 0.1) * 14.50;
        double thinnerPrice = neededThinner * 5;

        double sum = nylonPrice + paintPrice + thinnerPrice + 0.40;
        double buildersPrice = (sum * 0.3) * neeededHours;

        double totalPrice = sum + buildersPrice;

        System.out.println(totalPrice);
    }
}
