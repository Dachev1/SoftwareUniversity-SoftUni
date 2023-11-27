package ProgrammingFundamentals.Lists.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //3 3 6 1
        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).collect(Collectors.toList());


        for (int i = 0; i < numbers.size() - 1; i++) {
            double currentNumber = numbers.get(i);
            double nextNumber = numbers.get(i + 1);

            if (currentNumber == nextNumber) {
                numbers.set(i, currentNumber + nextNumber);
                numbers.remove(i + 1);

                i = -1;
            }
        }

        DecimalFormat df = new DecimalFormat("0.###");
        for (double num : numbers) {
            System.out.print(df.format(num) + " ");
        }
    }
}
