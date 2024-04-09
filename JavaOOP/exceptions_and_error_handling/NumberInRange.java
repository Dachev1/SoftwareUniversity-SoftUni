package exceptions_and_error_handling;

import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    private static int start;
    private static int end;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        start = range[0];
        end = range[1];

        System.out.printf("Range: [%d...%d]\n", start, end);

        while (true) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (isInRange(number)) {
                    System.out.println("Valid number: " + number);
                    return;
                } else {
                    System.out.println("Invalid number: " + number);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number: " + input);
            }
        }
    }

    public static boolean isInRange(int number) {
        return start <= number && number <= end;
    }
}
