package Exercise_September_15.MoreExercise;

import java.util.Scanner;

public class P03_GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());

        double spentMoney = 0;
        String input = scanner.nextLine();
        while (!input.equals("Game Time")) {
            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (budget >= 39.99) {
                        budget -= 39.99;
                        spentMoney += 39.99;
                        System.out.printf("Bought %s\n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if (budget >= 15.99) {
                        budget -= 15.99;
                        spentMoney += 15.99;
                        System.out.printf("Bought %s\n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if (budget >= 19.99) {
                        budget -= 19.99;
                        spentMoney += 19.99;
                        System.out.printf("Bought %s\n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if (budget >= 59.99) {
                        budget -= 59.99;
                        spentMoney += 59.99;
                        System.out.printf("Bought %s\n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if (budget >= 29.99) {
                        budget -= 29.99;
                        spentMoney += 29.99;
                        System.out.printf("Bought %s\n", input);
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            if (budget <= 0) {
                System.out.println("Out of money!");
                return;
            }

            input = scanner.nextLine();
        }

        System.out.printf("Total spent: $%.2f. Remaining: $%.2f", spentMoney, budget);
    }
}
