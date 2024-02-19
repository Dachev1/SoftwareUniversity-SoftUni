package ExamPreparation.December_15_2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(males::push);

        Deque<Integer> females = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(females::offer);

        int matchesCount = 0;
        while (!females.isEmpty() && !males.isEmpty()) {
            int female = females.poll();
            int male = males.pop();

            if (female <= 0) {
                males.push(male);
                continue;
            }  else if (female % 25 == 0) {
                if (females.size() > 0) {
                    females.poll();
                    males.push(male);
                    continue;
                }
            }
            if (male <= 0) {
                females.addFirst(female);
                continue;
            } else if (male % 25 == 0) {
                if (males.size() > 0) {
                    males.pop();
                    females.addFirst(female);
                    continue;
                }
            }

            if (female == male) {
                matchesCount++;
                continue;
            } else {
                males.push(male - 2);
            }
        }

        System.out.println("Matches: " + matchesCount);

        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.printf("Males left: %s\n", males.toString().replaceAll("[\\[\\]]", ""));
        }

        if (females.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.printf("Females left: %s\n", females.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
