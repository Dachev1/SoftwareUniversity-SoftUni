package Lecture_05;

import java.util.Scanner;

public class P04_Sequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input ; i = (i * 2) + 1) {
            System.out.println(i);
        }
    }
}
