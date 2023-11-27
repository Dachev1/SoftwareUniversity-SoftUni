package ProgrammingFundamentals.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sequence = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String specialNumAndPower = scanner.nextLine();
        int specialNumIndex = 0;
        // изкарваме променливите извън цикъла.
        int specialNum = Integer.parseInt(String.valueOf(specialNumAndPower.split(" ")[0]));
        int numberPower = Integer.parseInt(String.valueOf(specialNumAndPower.split(" ")[1]));

        while (sequence.contains(specialNum)) { //цикълът върти докато има специално число в листа.
            specialNumIndex = sequence.indexOf(specialNum); // намираме индекса на специалното число.
            int leftNumberPower = Math.max(specialNumIndex - numberPower, 0); // взимаме максилното число от 0 и разликата от индекса на специалносто число и numberPower
            int rightNumberPower = Math.min(specialNumIndex + numberPower, sequence.size() - 1); // взимаме минималното число от сбора от индекса на специалносто число и numberPower и размера на листа минус 1.
            sequence.subList(leftNumberPower, rightNumberPower + 1).clear(); // изтриваме всички числа от leftNumberPower до rightNumberPower.
        }


        int sequenceSum = 0;
        for (int i = 0; i < sequence.size(); i++) {
            sequenceSum += sequence.get(i);
        }
        System.out.println(sequenceSum);  // Може и на един ред така: System.out.println(sequence.stream().mapToInt(Integer::intValue).sum());
    }
}
