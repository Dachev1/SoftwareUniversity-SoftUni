package Lecture_02.LectureEXC_02;

import java.util.Scanner;

public class LunchBreak_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String series = scanner.nextLine();
        int duration = Integer.parseInt(scanner.nextLine());
        int freeTime = Integer.parseInt(scanner.nextLine());

        double lunchTime = freeTime / 8.0;
        double relaxTime = freeTime / 4.0;
        double timeLeft = freeTime - (lunchTime + relaxTime);

        if (timeLeft >= duration) {
            double left = Math.ceil(timeLeft - duration);
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", series, left);
        } else  {
            double left =  Math.ceil(duration - timeLeft);
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", series, left);
        }
    }
}
