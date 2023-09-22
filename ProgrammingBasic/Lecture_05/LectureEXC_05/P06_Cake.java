package Lecture_05.LectureEXC_05;

import java.util.Scanner;

public class P06_Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());

        int pieceCount = length * width;
        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int pieceTaken = Integer.parseInt(input);

            pieceCount -= pieceTaken;
            if (pieceCount < 0) {
                break;
            }

            input = scanner.nextLine();
        }

        if (input.equals("STOP")) {
            System.out.printf("%d pieces are left.", pieceCount);
        } else {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(pieceCount));
        }
    }
}
