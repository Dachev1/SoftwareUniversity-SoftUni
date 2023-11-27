package ProgrammingFundamentals.MidExamsPractise.Exam5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersSequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        int sumOfAllNumbers = 0;
        for (int number : numbersSequence) {
            sumOfAllNumbers += number;
        }

        double averageNumber = (sumOfAllNumbers * 1.0) / numbersSequence.size();

        for (int i = 0; i < numbersSequence.size(); i++) {
            int currentNumber = numbersSequence.get(i);

            if (currentNumber > averageNumber) {
                result.add(currentNumber);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No");
        }
        Collections.sort(result);
        Collections.reverse(result);
        //List<Staff> second = magicMethodForClone(staffs,20);

       List<Integer> limitedList = result.stream().limit(5).collect(Collectors.toList());

       for (int number : limitedList) {
           System.out.print(number + " ");
       }
    }
}
