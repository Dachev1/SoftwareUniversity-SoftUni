package Lecture_01.LectureEXC_01;

import java.util.Scanner;

public class FishTank_09 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int  lengthCm = Integer.parseInt(scanner.nextLine());
        int  widthCm = Integer.parseInt(scanner.nextLine());
        int  heightCm = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        int aquariumVolume = lengthCm * widthCm * heightCm;
        double volumeLiters = aquariumVolume / 1000.0;
        double spaceOccupied = percent / 100;
        double neededLiters = volumeLiters * (1 - spaceOccupied);

        System.out.println(neededLiters);
    }
}
