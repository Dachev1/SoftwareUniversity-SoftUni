package Lecture_02.LectureEXC_02;

import java.util.Scanner;

public class BonusScore_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num =Integer.parseInt(scanner.nextLine());
        double score = 0;

        if (num <= 100) {
            score = 5;
        } else  if (num > 1000) {
            score = num * 0.1;
        } else {
            score = num * 0.2;
        }

        if (num % 2 == 0) {
            score++;
        } else if (num % 10 == 5) {
            score += 2;
        }

        System.out.println(score);
        System.out.println(num + score);
    }
}
