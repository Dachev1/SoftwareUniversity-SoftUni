package ExamPreparation.June_25_2022;

import java.util.*;
import java.util.stream.DoubleStream;

public class ItsChocolateTime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milks = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(milks::offer);

        Deque<Double> cacaoPowders = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .forEach(cacaoPowders::push);


        int milkChocolates = 0;
        int darkChocolates = 0;
        int bakingChocolates = 0;

        while (!milks.isEmpty() && !cacaoPowders.isEmpty()) {
            double milkValue = milks.poll();
            double cacaoPowderValue = cacaoPowders.pop();

            double cacaoPercentage = cacaoPowderValue / (cacaoPowderValue + milkValue) * 100;

            if (cacaoPercentage == 30) {
                milkChocolates++;
            } else if (cacaoPercentage == 50) {
                darkChocolates++;
            } else if (cacaoPercentage == 100) {
                bakingChocolates++;
            } else {
                milkValue += 10;
                milks.offer(milkValue);
            }
        }

        if (milkChocolates != 0 && darkChocolates != 0 && bakingChocolates != 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        if (bakingChocolates > 0) {
            System.out.printf("# Baking Chocolate --> %d%n", bakingChocolates);
        }
        if (darkChocolates > 0) {
            System.out.printf("# Dark Chocolate --> %d%n", darkChocolates);
        }
        if (milkChocolates > 0) {
            System.out.printf("# Milk Chocolate --> %d%n", milkChocolates);
        }
    }
}