package Lecture_06;

import java.util.Scanner;

public class P06_Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countFloors = Integer.parseInt(scanner.nextLine());
        int countRooms = Integer.parseInt(scanner.nextLine());

        for (int floors = countFloors; floors >= 1 ; floors--) {
            for (int rooms = 0; rooms < countRooms; rooms++) {
                if (floors == countFloors) {
                    System.out.print("L" + floors + rooms + " ");
                } else if (floors % 2 == 0) {
                    System.out.print("O" + floors + rooms + " ");
                } else {
                    System.out.print("A" + floors + rooms + " ");
                }
            }

            System.out.println();
        }
    }
}
