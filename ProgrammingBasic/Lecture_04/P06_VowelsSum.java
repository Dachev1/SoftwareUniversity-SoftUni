package Lecture_04;

import java.util.Scanner;

public class P06_VowelsSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int vowelsSum = 0;

        for (int i = 0; i < text.length(); i++) {
            char textChar = text.charAt(i);

            switch (textChar) {
                case 'a':
                    vowelsSum += 1;
                    break;
                case 'e':
                    vowelsSum += 2;
                    break;
                case 'i':
                    vowelsSum += 3;
                    break;
                case 'o':
                    vowelsSum += 4;
                    break;
                case 'u':
                    vowelsSum += 5;
                    break;
            }
        }

        System.out.println(vowelsSum);
    }
}
