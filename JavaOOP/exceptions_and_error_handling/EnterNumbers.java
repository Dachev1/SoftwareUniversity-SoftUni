package exceptions_and_error_handling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EnterNumbers {
    
    private static int start;
    private static int end;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>();

        start = 1;
        end = 100;


        int counter = 0;
        while (counter < 10) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (isInRange(number)) {
                    numbers.add(input);
                    start = number;
                    counter++;
                } else {
                    throw new IOException(String.format("Your number is not in range %d - 100!", start));
                }
            }catch (IOException exception) {
                System.out.printf("%s%n", exception.getMessage());
            } catch (NumberFormatException exception) {
                System.out.printf("Invalid Number!%n");
            }
        }

        System.out.println(String.join(", ", numbers));
    }
    
    public static boolean isInRange(int number) {
        return start < number && number < end;
    }
}
