package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P02_MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeForPhotos = Integer.parseInt(scanner.nextLine());
        int scenesCount = Integer.parseInt(scanner.nextLine());
        int durationOfScene = Integer.parseInt(scanner.nextLine());

        double fieldPreparation = timeForPhotos * 0.15;
        double neededTime = scenesCount * durationOfScene + fieldPreparation;

        double diff = Math.abs(timeForPhotos - neededTime);
        if (neededTime > timeForPhotos) {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", diff);
        } else {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", diff);
        }
    }
}
