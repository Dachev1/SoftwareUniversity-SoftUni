package Exam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ChickenSnack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> moneySequence = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(moneySequence::push);

        Deque<Integer> pricesSequence = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(pricesSequence::offer);

        int foodCount = 0;
        while (!moneySequence.isEmpty() && !pricesSequence.isEmpty()) {
            int amount = moneySequence.pop();
            int price = pricesSequence.poll();

            if (amount == price) {
                foodCount++;
            } else if (amount > price) {
                foodCount++;
                amount -= price;
                if (moneySequence.size() > 0) {
                    moneySequence.push(moneySequence.pop() + amount);
                }
            }
        }

        if (foodCount >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.\n", foodCount);
        }

        if (foodCount > 1 && foodCount < 4) {
            System.out.printf("Henry ate: %d foods.\n", foodCount);
        }

        if (foodCount == 1) {
            System.out.printf("Henry ate: %d food.\n", foodCount);
        }

        if (foodCount <= 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        }
    }
}
