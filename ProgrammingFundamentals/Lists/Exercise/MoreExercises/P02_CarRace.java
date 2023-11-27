package ProgrammingFundamentals.Lists.Exercise.MoreExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> raceTrack = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double leftRacerTime = 0;
        double rightRacerTime = 0;

        for (int i = 0; i < raceTrack.size() / 2; i++) {
            leftRacerTime += raceTrack.get(i);
            if (raceTrack.get(i) == 0) {
                leftRacerTime *= 0.8;
            }
        }

        for (int i = raceTrack.size() - 1; i > raceTrack.size() / 2; i--) {
            rightRacerTime += raceTrack.get(i);
            if (raceTrack.get(i) == 0) {
                rightRacerTime *= 0.8;
            }
        }

        if (leftRacerTime < rightRacerTime) {
            System.out.printf("The winner is left with total time: %.1f\n", leftRacerTime);
        } else {
            System.out.printf("The winner is right with total time: %.1f\n", rightRacerTime);
        }
    }
}
