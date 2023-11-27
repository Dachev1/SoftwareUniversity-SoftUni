package ProgrammingFundamentals.Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[n];

        int sum = 0;
        for (int i = 0; i < wagons.length; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            wagons[i] = people;
            sum += people;
        }

        System.out.println(Arrays.toString(wagons)
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );

        System.out.println(sum);
    }
}
