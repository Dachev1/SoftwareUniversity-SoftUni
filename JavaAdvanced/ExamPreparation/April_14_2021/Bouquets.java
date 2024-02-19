package ExamPreparation.April_14_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Bouquets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bouquets = 0;

        Deque<Integer> daffodils = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);

        Deque<Integer> tulips = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);

        int storedSum = 0;
        while (!daffodils.isEmpty() && !tulips.isEmpty()) {
            int daffodil = daffodils.poll();
            int tulip = tulips.pop();

            int sum = daffodil + tulip;

            if (sum >= 15) {
                bouquets++;
            } else {
                storedSum += sum;
            }
        }

        bouquets += storedSum / 15;
        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!\n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.\n", Math.abs(bouquets - 5));
        }
    }
}
