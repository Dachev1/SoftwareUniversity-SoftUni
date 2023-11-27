package ProgrammingFundamentals.Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06_CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> hands1 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> hands2 = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        int size = Math.min(hands1.size(), hands2.size());

        for (int i = 0; i < size; i++) {
            if (hands1.isEmpty() || hands2.isEmpty()) {
                break;
            }
            int firstCards = hands1.get(i);
            int secondCards = hands2.get(i);


            if (firstCards > secondCards) {
                hands1.remove(i);
                hands1.add(secondCards);
                hands1.add(firstCards);

                hands2.remove(hands2.indexOf(secondCards));
            } else if (secondCards > firstCards) {
                hands2.remove(i);
                hands2.add(firstCards);
                hands2.add(secondCards);

                hands1.remove(hands1.indexOf(firstCards));
            } else {
                hands1.remove(hands1.indexOf(firstCards));
                hands2.remove(hands2.indexOf(secondCards));
            }

            i = -1;
        }


        int firstPlayerPoints = 0;
        for (int card : hands1) {
            firstPlayerPoints += card;
        }

        int secondPlayerPoints = 0;
        for (int card : hands2) {
            secondPlayerPoints += card;
        }

        if (firstPlayerPoints > secondPlayerPoints) {
            System.out.printf("First player wins! Sum: %d", firstPlayerPoints);
        } else {
            System.out.printf("Second player wins! Sum: %d", secondPlayerPoints);
        }
    }
}
