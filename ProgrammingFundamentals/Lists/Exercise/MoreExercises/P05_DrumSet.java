package ProgrammingFundamentals.Lists.Exercise.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> startingSet = new ArrayList<>((drumSet));

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Hit it again, Gabsy!")) {
                break;
            }

            int hitPower = Integer.parseInt(input);

            for (int i = 0; i < drumSet.size(); i++) {
                int currentSetQuality = drumSet.get(i);
                int afterHit = currentSetQuality - hitPower;

                if (afterHit <= 0) {
                    int priceOfNewDrum = startingSet.get(i) * 3;
                    if (savings >= priceOfNewDrum) {
                        drumSet.set(i, startingSet.get(i));
                        savings -= priceOfNewDrum;
                    } else {
                        if (i == drumSet.size() - 1) {
                            drumSet.remove(i);
                        } else {
                            drumSet.remove(i);
                            startingSet.remove(i);
                            i--;
                        }

                    }
                } else {
                    drumSet.set(i, afterHit);
                }
            }
        }

        System.out.println(String.format(String.valueOf(drumSet))
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
        );

        System.out.printf("Gabsy has %.2flv.\n", savings);
    }
}
