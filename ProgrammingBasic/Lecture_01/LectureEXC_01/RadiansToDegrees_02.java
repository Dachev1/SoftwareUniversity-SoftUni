package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class RadiansToDegrees_02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double radian = Double.parseDouble(scanner.nextLine());
        double raduis = radian * 180 / Math.PI;

        System.out.println(raduis);
    }
}
