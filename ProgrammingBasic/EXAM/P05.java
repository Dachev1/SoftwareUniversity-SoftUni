package EXAM;

import java.util.Scanner;

public class P05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int theMostScoredGoals = Integer.MIN_VALUE;
        String bestFootBallPlayer = "";
        boolean isHatTrick = false;

        while (!name.equals("END")) {
            int scoredGoals = Integer.parseInt(scanner.nextLine());

            if (scoredGoals > theMostScoredGoals) {
                theMostScoredGoals = scoredGoals;
                bestFootBallPlayer = name;
            }

            if (scoredGoals >= 3) {
                isHatTrick = true;
            }

            if (scoredGoals >= 10) {
                break;
            }
            name = scanner.nextLine();
        }


        System.out.printf("%s is the best player!%n", bestFootBallPlayer);

        if (isHatTrick) {
            System.out.printf("He has scored %d goals and made a hat-trick !!!", theMostScoredGoals);
        } else {
            System.out.printf("He has scored %d goals.", theMostScoredGoals);
        }

    }
}