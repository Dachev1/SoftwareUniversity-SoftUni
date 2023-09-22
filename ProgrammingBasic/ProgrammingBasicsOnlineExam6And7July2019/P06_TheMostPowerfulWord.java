package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P06_TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double bestPoints = 0;
        String wordWinner = "";

        while (!input.equals("End of words")) {
            int points = 0;
            double currentResult = 0;

            for (int i = 0; i < input.length(); i++) {
                points += input.charAt(i);

                if (input.charAt(0) == 'a' ||
                        input.charAt(0) == 'e' ||
                        input.charAt(0) == 'i' ||
                        input.charAt(0) == 'o' ||
                        input.charAt(0) == 'u' ||
                        input.charAt(0) == 'y' ||
                        input.charAt(0) == 'A' ||
                        input.charAt(0) == 'E' ||
                        input.charAt(0) == 'I' ||
                        input.charAt(0) == 'O' ||
                        input.charAt(0) == 'U' ||
                        input.charAt(0) == 'Y') {

                    currentResult = points * input.length();
                } else {
                    currentResult = Math.floor(points * 1.0 / input.length());
                }

                if (currentResult > bestPoints) {
                    bestPoints = currentResult;
                    wordWinner = input;
                }
            }
            input = scanner.nextLine();

        }

        System.out.printf("The most powerful word is %s - %.0f", wordWinner, bestPoints);

    }
}
