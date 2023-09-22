package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P01_PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = Integer.parseInt(scanner.nextLine());
        double tax = Double.parseDouble(scanner.nextLine());
        double sunLounger = Double.parseDouble(scanner.nextLine());
        double umbrella = Double.parseDouble(scanner.nextLine());

        double total = 0;
        double sunLoungerTotalPrice = 0;
        double umbrellaTotalPrice = 0;

        sunLoungerTotalPrice += (Math.ceil(peopleCount * 0.75)) * sunLounger;
        umbrellaTotalPrice += (Math.ceil(peopleCount * 0.50)) * umbrella;
        total += (peopleCount * tax) + sunLoungerTotalPrice + umbrellaTotalPrice;

        System.out.printf("%.2f lv." , total);

    }
}
