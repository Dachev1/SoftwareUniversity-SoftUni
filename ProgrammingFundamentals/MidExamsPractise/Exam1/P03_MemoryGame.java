package ProgrammingFundamentals.MidExamsPractise.Exam1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        int turns = 0;
        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) {
                break;
            }

            turns++;
            int idx1 = Integer.parseInt(line.split(" ")[0]);
            int idx2 = Integer.parseInt(line.split(" ")[1]);

            if (idx1 == idx2) {
                invalidInput(sequence, turns);
            } else if (!(idx1 >= 0 && idx1 < sequence.size() && idx2 >= 0 && idx2 < sequence.size())) {
                invalidInput(sequence, turns);
            } else {

            String firstElement = sequence.get(idx1);
            String secondElement = sequence.get(idx2);

            if (firstElement.equals(secondElement)) {
                System.out.printf("Congrats! You have found matching elements - %s!\n", firstElement);
                sequence.remove(firstElement);
                sequence.remove(secondElement);

                } else {
                System.out.println("Try again!");
                }
            }

            if (sequence.size() <= 0) {
                System.out.printf("You have won in %d turns!", turns);
                return;
            }
        }

        System.out.println("Sorry you lose :(");
        for (String el : sequence) {
            System.out.print(el + " ");
        }
    }

    private static void invalidInput(List<String> sequence, int turns) {
        sequence.add(sequence.size() / 2, "-" + turns + "a");
        sequence.add(sequence.size() / 2 + 1, "-" + turns + "a");
        System.out.println("Invalid input! Adding additional elements to the board");
    }
}
