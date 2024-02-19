package BasicAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(numbers);

        System.out.println(String.join(" ", numbers.toString().replaceAll("[\\[\\]]","")
                .replaceAll(",", "")));
    }
}
