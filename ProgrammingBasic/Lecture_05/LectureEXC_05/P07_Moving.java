package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P07_Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        int totalAvailableSpace = width * length * height;
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int boxSpace = Integer.parseInt(input);
            totalAvailableSpace -= boxSpace;

            if (totalAvailableSpace < 0) {
                break;
            }

            input = scanner.nextLine();
        }

        if (input.equals("Done")) {
            System.out.printf("%d Cubic meters left.", totalAvailableSpace);
        } else {
            System.out.printf("No more free space! You need %d Cubic meters more.", Math.abs(totalAvailableSpace));
        }
    }
}
