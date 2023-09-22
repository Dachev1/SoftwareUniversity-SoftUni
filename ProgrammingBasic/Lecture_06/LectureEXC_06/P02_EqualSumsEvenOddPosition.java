package Lecture_06.LectureEXC_06;

import java.util.Scanner;

public class P02_EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());

        for (int currentNumber = startNumber; currentNumber <= endNumber ; currentNumber++) {

            int digitOne = currentNumber / 100000;
            int digitTwo = currentNumber / 10000 % 10;
            int digitThree= currentNumber / 1000 % 10;
            int digitFour = currentNumber / 100 % 10;
            int digitFive = currentNumber / 10 % 10;
            int digitSix = currentNumber % 10;

            int evenSum = digitTwo + digitFour + digitSix;
            int oddSum = digitOne + digitThree + digitFive;

            if (evenSum == oddSum) {
                System.out.print(currentNumber + " ");
            }
        }
    }
}
