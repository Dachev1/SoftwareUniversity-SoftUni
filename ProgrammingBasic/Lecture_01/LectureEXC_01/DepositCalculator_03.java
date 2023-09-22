package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class DepositCalculator_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double depositSum = Double.parseDouble(scanner.nextLine());
        int depositPerMonth = Integer.parseInt(scanner.nextLine());
        double yearPercent = Double.parseDouble(scanner.nextLine());

        double sum = depositSum + depositPerMonth * ((depositSum * (yearPercent / 100)) / 12);

        System.out.println(sum);
    }
}

