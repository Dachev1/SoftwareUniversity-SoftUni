package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class VacationBooksList_04 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int pagesCount = Integer.parseInt(scanner.nextLine());
        int pagesReadedForOneHour = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        int totalTime = pagesCount / pagesReadedForOneHour;
        int timePerDay = totalTime / days;

        System.out.println(timePerDay);

    }
}
