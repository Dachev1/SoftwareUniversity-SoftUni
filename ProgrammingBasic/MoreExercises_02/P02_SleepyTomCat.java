package MoreExercises_02;

import java.util.Scanner;

public class P02_SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int holidays = Integer.parseInt(scanner.nextLine());

        int workDays = 365 - holidays;
        int playTime = workDays * 63 + holidays * 127;
        int norm = 30000;
        int diff = Math.abs(norm - playTime);

        if (playTime > norm) {
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play",
                    diff / 60,
                    diff % 60
            );
        } else {
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play",
                    diff / 60,
                    diff % 60
            );
        }
    }
}
