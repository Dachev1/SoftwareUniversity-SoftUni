package Lecture_04.LectureEXC_04;

import java.util.Scanner;

public class P07_TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupCount = Integer.parseInt(scanner.nextLine());

        int totalPeople = 0;

        int musalla = 0;
        int montBlanc = 0;
        int kilimanjaro  = 0;
        int k2 = 0;
        int everest  = 0;

        for (int i = 1; i <= groupCount; i++) {
            int peopleInGroup = Integer.parseInt(scanner.nextLine());
            totalPeople += peopleInGroup;

            if (peopleInGroup < 6) {
                musalla += peopleInGroup;
            } else if (peopleInGroup < 13) {
                montBlanc += peopleInGroup;
            } else if (peopleInGroup < 26) {
                kilimanjaro += peopleInGroup;
            } else if (peopleInGroup < 41) {
                k2 += peopleInGroup;
            } else {
                everest += peopleInGroup;
            }
        }

        double musallPercent = (musalla * 1.0 / totalPeople) * 100;
        double montBlancPercent = (montBlanc * 1.0 / totalPeople) * 100;
        double kilimanjaroPercent = (kilimanjaro * 1.0 / totalPeople) * 100;
        double k2Percent = (k2 * 1.0 / totalPeople) * 100;
        double everestPercent = (everest * 1.0 / totalPeople) * 100;

        System.out.printf("%.2f%%%n" , musallPercent);
        System.out.printf("%.2f%%%n" , montBlancPercent);
        System.out.printf("%.2f%%%n" , kilimanjaroPercent);
        System.out.printf("%.2f%%%n" , k2Percent);
        System.out.printf("%.2f%%%n" , everestPercent);
    }
}
