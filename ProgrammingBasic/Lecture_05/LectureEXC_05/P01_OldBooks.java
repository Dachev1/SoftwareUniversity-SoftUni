package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P01_OldBooks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String searchBook = scanner.nextLine();
        String input = scanner.nextLine();

        int checkCount = 0;

        while (!input.equals("No More Books")) {
            if (input.equals(searchBook)) {
                break;
            }

            checkCount++;
            input = scanner.nextLine();
        }

        if (input.equals("No More Books")) {
            System.out.println("The book you search is not here!");
            System.out.printf("You checked %d books.", checkCount);
        } else {
            System.out.printf("You checked %d books and found it.", checkCount);
        }
    }
}
