package ExamPreparation.February_20_2021;

import java.util.*;
import java.util.stream.IntStream;

public class MagicBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstMagicBox = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstMagicBox::offer);

        Deque<Integer> secondMagicBox = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondMagicBox::push);

        List<Integer> claimedItems = new ArrayList<>();
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()) {
            int firstBoxItem = firstMagicBox.poll();
            int secondBoxItem = secondMagicBox.pop();

            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0) {
                claimedItems.add(sum);
            } else {
                firstMagicBox.addFirst(firstBoxItem);
                firstMagicBox.offer(secondBoxItem);
            }
        }

        if (firstMagicBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        int totalSum = 0;
        for (Integer item : claimedItems) {
            totalSum += item;
        }

        if (totalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d\n", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d\n", totalSum);
        }
    }
}
