package ProgrammingBasicsOnlineExam6And7April2019;

import java.util.Scanner;

public class P01_OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rentHall = Integer.parseInt(scanner.nextLine());

        double figurinesPrice = rentHall * 0.70;
        double cateringPrice = figurinesPrice * 0.85;
        double voiceOverPrice = cateringPrice / 2;

        System.out.printf("%.2f", rentHall + figurinesPrice + cateringPrice + voiceOverPrice);
    }
}
