package Lecture_02.LectureEXC_02;

import java.util.Scanner;

public class WorldSwimmingRecord_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double secondPerOneMeter = Double.parseDouble(scanner.nextLine());

        double delay = (Math.floor(distance / 15.0)) * 12.5;
        double total = (distance * secondPerOneMeter) + delay;

        if (record > total) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", total);
        } else {
            double diff = total - record;
            System.out.printf("No, he failed! He was %.2f seconds slower.", diff);
        }
    }
}
