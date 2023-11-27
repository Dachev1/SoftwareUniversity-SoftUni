package ProgrammingFundamentals.Lists.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1 2 3 4 5

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                        .split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        int size = numbers.size();
        for (int i = 0; i < size / 2; i++) {
            int currentEl = numbers.get(i);
            int lastEl = numbers.get(numbers.size() - 1);

            numbers.set(i, currentEl + lastEl);
            numbers.remove(numbers.size() - 1);
        }

        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
