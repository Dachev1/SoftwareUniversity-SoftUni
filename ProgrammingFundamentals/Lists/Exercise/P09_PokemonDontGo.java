package ProgrammingFundamentals.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int removedElementsSum = 0;
        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index <= numbers.size() - 1) {
                int removedElement = numbers.get(index);
                removedElementsSum += removedElement;
                numbers.remove(index);

                modifyList(numbers, removedElement);
            } else if (index < 0) {
                int removeFirstElement = numbers.get(0);
                removedElementsSum += removeFirstElement;
                numbers.remove(0);

                int lastNumber = numbers.get(numbers.size() - 1);
                numbers.add(0, lastNumber);

                modifyList(numbers, removeFirstElement);
            } else if (index > numbers.size() - 1) {
                int removeLastElement = numbers.get(numbers.size() - 1);
                removedElementsSum += removeLastElement;
                numbers.remove(numbers.size() - 1);

                int firstNumber = numbers.get(0);
                numbers.add(firstNumber);
                modifyList(numbers, removeLastElement);
            }
        }

        System.out.println(removedElementsSum);
    }

    private static void modifyList(List<Integer> numbersSeq, int removedElement) {
        for (int i = 0; i < numbersSeq.size(); i++) {
            int currentElement = numbersSeq.get(i);

            if (currentElement <= removedElement) {
                numbersSeq.set(i, currentElement + removedElement);
            } else {
                numbersSeq.set(i, currentElement - removedElement);
            }
        }
    }
}
