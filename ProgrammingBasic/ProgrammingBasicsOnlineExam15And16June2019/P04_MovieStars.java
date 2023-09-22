package ProgrammingBasicsOnlineExam15And16June2019;

import java.util.Scanner;

public class P04_MovieStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        String actorName = scanner.nextLine();

        while (!actorName.equals("ACTION")) {

            if (actorName.length() > 15) {
                budget *= 0.80;

                actorName = scanner.nextLine();
                continue;
            }

                double salary = Double.parseDouble(scanner.nextLine());

            if (budget <= salary) {
                budget -= salary;
                break;
            }

                budget -= salary;


            actorName = scanner.nextLine();
        }

        if (budget <= 0) {
            System.out.printf("We need %.2f leva for our actors.", Math.abs(budget));
        } else {
            System.out.printf("We are left with %.2f leva.", budget);
        }
    }
}
