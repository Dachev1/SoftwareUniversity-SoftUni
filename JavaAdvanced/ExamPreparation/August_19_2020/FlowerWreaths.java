package ExamPreparation.August_19_2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class FlowerWreaths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> lilies = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(lilies::push);

        Deque<Integer> roses = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(roses::offer);

        int wreath = 0;
        int flowersLeft = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int lilie = lilies.pop();
            int rose = roses.poll();

            int sum = lilie + rose;

            if (sum >= 15) {
                wreath++;
            } else {
                flowersLeft += sum;
            }
        }

        wreath += flowersLeft / 15;

        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!\n", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!\n", Math.abs(wreath - 5));
        }
    }
}
