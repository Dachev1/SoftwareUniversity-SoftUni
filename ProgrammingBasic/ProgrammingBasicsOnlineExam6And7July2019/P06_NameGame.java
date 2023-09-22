package ProgrammingBasicsOnlineExam6And7July2019;

import java.util.Scanner;

public class P06_NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int bestPoints = 0;
        String winner = "";

        while (!name.equals("Stop")) {
            int currentPoints = 0;
            for (int i = 0; i < name.length() ; i++) {
                int number = Integer.parseInt(scanner.nextLine());

                if (number == name.charAt(i)) {
                    currentPoints += 10;
                } else {
                    currentPoints += 2;
                }
            }

            if (currentPoints >= bestPoints) {
                bestPoints = currentPoints;
                winner = name;
            }

            name = scanner.nextLine();
        }
        System.out.println(String.format("The winner is %s with %d points!", winner, bestPoints));
    }
}
